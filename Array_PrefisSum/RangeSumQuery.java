package Array_PrefisSum;

public class RangeSumQuery {
    public static long[] rangeSum(int[] A, int[][] B) {
        long[] prefixSum = new long[A.length];
        prefixSum[0]=A[0];
        for(int i=1;i<A.length;i++){
            prefixSum[i]=prefixSum[i-1]+A[i];
        }
        long[] output = new long[B.length];
        for(int j =0;j<B.length;j++){
            if(B[j][0]==1){
                output[j] = prefixSum[B[j][1]-1];
            }
            
            else {output[j] = (prefixSum[B[j][1]-1]-prefixSum[B[j][0]-1-1]);}
        }
        return output;
    
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[][] B = {{1, 4},{2, 3}};
        long[] output = rangeSum(A,B);
        for (long integer : output) {
            System.out.print(integer + " ");
        }
    }
}
