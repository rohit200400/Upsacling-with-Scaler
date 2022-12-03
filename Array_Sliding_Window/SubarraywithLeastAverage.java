/*Problem Description
Given an array of size N, find the subarray of size K with the least average.

Problem Constraints
1<=k<=N<=1e5
-1e5<=A[i]<=1e5


Input Format
First argument contains an array A of integers of size N.
Second argument contains integer k.


Output Format
Return the index of the first element of the subarray of size k that has least average.
Array indexing starts from 0.


Example Input
Input 1:
A=[3, 7, 90, 20, 10, 50, 40]
B=3
Input 2:

A=[3, 7, 5, 20, -10, 0, 12]
B=2


Example Output
Output 1:
3
Output 2:
4

Example Explanation
Explanation 1:
Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average 
among all subarrays of size 3.
Explanation 2:

 Subarray between [4, 5] has minimum average */
package Array_Sliding_Window;

public class SubarraywithLeastAverage {
    public static void main(String[] args) {
        int[] A = {3, 7, 90, 20, 10, 50, 40};
        int size = 3;
        int count  = solve(A, size);
        System.out.println(count);
    }

    /**
     * @param A
     * @param B
     * @return
     */
    public static int solve(int[] A, int B) {
        if(B==1){
            int min = Integer.MAX_VALUE, index = -1;
            for(int i =0; i<A.length;i++){
                if(A[i]<min){
                    min = A[i];
                    index = i;
                }
            }
            return index;
        }
        int sum = 0;
        for(int i =0; i<B; i++){
            sum+=A[i];
        }
        int Avg = sum, idx=0;
        for(int i =B; i<A.length;i++){
            int avg = 0;
            sum-=A[i-B];
            sum+=A[i];
            avg = sum;
            if(Avg>avg){
                Avg = avg;
                idx = i-B+1;
            }
        }
        return idx;
    }
}
