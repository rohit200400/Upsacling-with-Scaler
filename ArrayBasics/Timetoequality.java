package ArrayBasics;

public class Timetoequality {
    public static int solve(int[] A) {
        int max = 0;
        int sum = 0;
        for(int element: A){
            sum+=element;
            if(element>max) max=element;
        }
        int maxSum = max*A.length;
        return maxSum-sum;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int output = solve(A);
        System.out.println(output);
    }
}
