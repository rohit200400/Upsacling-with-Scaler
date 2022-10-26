package ArrayBasics;

public class SecondLargest {
    public static  int solve(int[] A) {
        if(A.length==1) return -1;
        int max = A[0];
        for(int i=0;i<A.length;i++){
            if(A[i]>max){
                //secondMax=max;
                max=A[i];
            }
        }
        int secondMax=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==max)continue;
            if(A[i]>secondMax){
                //secondMax=max;
                secondMax=A[i];
            }
        }
        return secondMax;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 1, 7, 8, 9};
        int output = solve(array);
        System.out.println(output);
    }
}
