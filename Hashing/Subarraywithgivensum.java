/*Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1:

 [2, 3]
Output 2:

 -1


Example Explanation
Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number. */
package Hashing;

public class Subarraywithgivensum {
    public static void main(String[] args) {
        int[] A = {52, 10, 3, 2, 50, 80};
        int B = 5;
        int[] out = solve(A, B);
        if(out[0]==-1){
            System.out.println("No subarray sums up to "+ B);
        }
        else{
            System.out.println("The first continuous sub-array which adds to "+B);
            for (int i : out) {
                System.out.print(i+" ");
            }
        }
    }
    public static int[] solve(int[] A, int B) {
        int st = 0, end = 0, N = A.length;
        long sum = 0;
        for(int i=0; i<N; i++){
            sum = sum + A[i];
            if(sum > B){
                while(sum > B){
                    sum = sum - A[st];
                    st++;
                }
            }
            if(sum == B){
                end = i;
                int length = end-st+1, j = 0;
                int[] ans = new int[length];
                for(int k=st; k<=end; k++){
                    ans[j++] = A[k];
                }
                return ans;
            }
        }
        return new int[] {-1};
    }
}
