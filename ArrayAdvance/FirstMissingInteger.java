package ArrayAdvance;

public class FirstMissingInteger {
    public static void main(String[] args) {
        int[] A = {-3, -4,1, 3, -5, -1,-2};
        System.out.println("The first missing positive integer in the array is "+firstMissingPositive(A));
    }
    public static int firstMissingPositive(int[] A) {
        // Handelling all the negative values
        for(int i=0;i<A.length;i++){
            if(A[i]<=0){
                A[i]=A.length+2;
            }
        }

        // for each positive we will make the element negative
        // i.e. if we found 1 in array we will multiply element
        // A[1-1] with -1.
        for(int i=0;i<A.length;i++){
            int ele = Math.abs(A[i]);
            if(ele < A.length){
                A[ele-1]=(-1*A[ele-1]);
            }
        }

        // checking the first missing element
        for(int i=0;i<A.length;i++){
            if(A[i]>0){
                return i+1;
            }
        }
        return A.length;
    }
}
