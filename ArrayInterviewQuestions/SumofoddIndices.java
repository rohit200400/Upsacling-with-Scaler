package ArrayInterviewQuestions;

public class SumofoddIndices {

    public static void main(String[] args) {
        int[] A = {2, 1, 8, 3, 9};
        int[][] B = {{0,3},{2,4}};
        int[] sumArr = solve(A, B);
        for (int i : sumArr) {
            System.out.println("Sum of odd element are " + i);
        }
    }

    public static int[] solve(int[] A, int[][] B) {
        int[] prefixOddSum = new int[A.length];
        //generating prefix array of even number
        int sum = 0;
        for(int i=0;i<A.length;i++){
            if(i%2!=0){
                sum+=A[i];
                prefixOddSum[i] = sum;
            }
            else{
                prefixOddSum[i] = sum;
            }
        }
        // intitating output array
        int[] oddSum = new int[B.length];
        for(int i =0; i<B.length;i++){
            if(B[i][0]==0){oddSum[i] = prefixOddSum[B[i][1]];}
            else {oddSum[i] = prefixOddSum[B[i][1]] - prefixOddSum[B[i][0]-1];}
        }
        return oddSum;
    }
}
