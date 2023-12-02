package Task2;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Task2.ExpressionEvaluator class for evaluating mathematical expressions concurrently with rate limiting.
 */
public class ExpressionEvaluator {

    private int CLIENT_RATE_LIMIT;
    private final AtomicBoolean PROCESSING = new AtomicBoolean(false);
    private final ExecutorService executorService;
    private final ConcurrentMap<String, RateLimiter> clientTokenBuckets;
    private BlockingQueue<Request> queue;
    private ApiAdaptor apiAdaptor;


    /**
     * Constructs an Task2.ExpressionEvaluator with necessary components.
     */
    public ExpressionEvaluator(int clientRatelimit, String url) {
        this.CLIENT_RATE_LIMIT = clientRatelimit;
        this.executorService = Executors.newVirtualThreadPerTaskExecutor();
        this.clientTokenBuckets = new ConcurrentHashMap<>();
        this.queue = new LinkedBlockingQueue<>();
        this.apiAdaptor = new ApiAdaptor(url);

    }

    /**
     * Evaluates expressions in the queue concurrently.
     */
    public void evaluateExpressions() {
        PROCESSING.set(true);
        while (!queue.isEmpty()) {
            Request processingRequest = queue.poll();
            if(processingRequest != null){
                String clientId = processingRequest.getClientId();
                String expression = processingRequest.getExpressions();
                try {
                    if (clientTokenBuckets.get(clientId).acquire()) {
                        executorService.submit(() -> {
                            String result = "";
                            try {
                                result = evaluateExpression(expression);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println(clientId + " : " + expression + " >> " + result);
                        });
                    } else {
                        queue.add(processingRequest);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        PROCESSING.set(false);
    }

    /**
     * Adds expressions to the queue for evaluation.
     *
     * @param expressions List of expressions to be evaluated.
     * @param clientId    Client identifier.
     */
    public void addExpressions(List<String> expressions, String clientId) {
        clientTokenBuckets.putIfAbsent(clientId, new RateLimiter(CLIENT_RATE_LIMIT));
        for (String expression : expressions) {
            queue.add(new Request(expression, clientId));
        }
        if (!PROCESSING.get()) {
            startEvaluation();
        }
    }

    /**
     * Starts the evaluation process in a separate thread.
     */
    private void startEvaluation() {
        Thread evaluationThread = new Thread(this::evaluateExpressions);
        evaluationThread.start();
    }

    /**
     * Evaluates a mathematical expression using a simulated web API call.
     *
     * @param expression Mathematical expression to be evaluated.
     * @return Result of the expression evaluation.
     * @throws InterruptedException If the evaluation is interrupted.
     */
    private String evaluateExpression(String expression) throws InterruptedException, IOException {
        String result  = apiAdaptor.evaluateExpression(expression);
        result = result.substring(11, result.indexOf(',')-1);
        return result;
    }

    /**
     * Shuts down the Task2.ExpressionEvaluator, waiting for ongoing evaluations to complete.
     *
     * @throws InterruptedException If the shutdown process is interrupted.
     */
    public void shutdown() throws InterruptedException {
        if (PROCESSING.get() || !queue.isEmpty()) {
            System.out.println("Some expressions are still being evaluated. Please try again later.");
        }
        while (PROCESSING.get() || !queue.isEmpty()) {
            Thread.sleep(2000);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
