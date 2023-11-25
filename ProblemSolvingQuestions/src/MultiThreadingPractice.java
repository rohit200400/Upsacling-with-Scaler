import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class MultiThreadingPractice {
    public static void main(String[] args) {
        List<Integer> l1 = new CopyOnWriteArrayList(List.of(1,4 ,5,2,76,2,7,3,56,9));
        Runnable r1 =()-> {
            System.out.println();
            l1.stream().filter(x -> x%2 != 0).forEach(x -> System.out.print(x + " "));
            System.out.println();
        };
        Runnable r2 = () -> {
            System.out.println();
            l1.stream().filter(x -> x%2 == 0).forEach(x -> System.out.print(x + " "));
            System.out.println();
        };
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
//        new Thread(r1).start();
//        new Thread(r2).start();
    }

}
