package BitManipulations;

public class SubarrayswithBitwiseOR {
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1, 1};
        int len = A.length;
        System.out.println("Total number of subarrays with bitwise OR of all elements are: " + solve(len, A));
    }

    public static long solve(int A, int[] B) {
        long cnt = 0;
        for(int i = 0 ; i < A ;i ++){
            int idx = B[i];
            if(idx == 1)  {//if first element is 1 then OR of whole 
            // subarray will be 1
                cnt+=(A-i);
                continue;// we will skip looping for other elements
            }
            for(int j = i+1 ; j < A ; j ++){
                // taking OR for every element as soon as it comes 1
                // we will take count of all the subarray after that
                idx = idx|B[j];
                if(idx==1){
                    cnt+= (A-j);
                    break;
                }
            }
        }
       return cnt;  
    }
}
