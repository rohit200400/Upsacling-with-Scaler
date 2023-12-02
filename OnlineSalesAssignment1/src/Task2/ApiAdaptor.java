package Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiAdaptor {
    private String apiUrl;

    public ApiAdaptor(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * Evaluates a mathematical expression using an external API.
     *
     * @param expression Mathematical expression to be evaluated.
     * @return Result of the expression evaluation.
     * @throws InterruptedException If the evaluation is interrupted.
     * @throws IOException          If an error occurs during the API call.
     */
    public String evaluateExpression(String expression) throws InterruptedException, IOException {
        String requestBody = "{\"expr\": \"" + expression + "\"}";

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }
        } else {
            // Handling non-OK response codes
            throw new RuntimeException("API request failed with response code: " + responseCode);
        }
    }
}
