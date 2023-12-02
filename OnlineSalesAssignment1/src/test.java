import Task2.ApiAdaptor;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApiAdaptor api = new ApiAdaptor("http://api.mathjs.org/v4/");
        String result  = api.evaluateExpression("2^2");
        result = result.substring(11, result.indexOf(',')-1);
        System.out.println(result);
    }

}
