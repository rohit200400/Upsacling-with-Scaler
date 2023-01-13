package ArrayAdvance;

public class RainWaterTrapped {
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2};
        System.out.println("Total units of trapped water is "+ trap(A));
    }

    public static int trap(final int[] A) {
        int[] leftMax = new int[A.length];
        int max = -1, sum=0;
        for(int i=0; i<A.length; i++){
            max = Math.max(max,A[i]);
            leftMax[i] = max;
        }
        max=-1;
        for(int i=(A.length-1); i>=0; i--){
            max = Math.max(max,A[i]);
            sum += Math.min(max,leftMax[i]) - A[i];
        }
        return sum;
    }
}