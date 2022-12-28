/*Problem Description
Given an array of integers A, of size N.

Return the maximum size subarray of A having only non-negative elements. If there are more than one such subarray, return the one having the smallest starting index in A.

NOTE: It is guaranteed that an answer always exists.



Problem Constraints
1 <= N <= 105

-109 <= A[i] <= 109



Input Format
The first and only argument given is the integer array A.



Output Format
Return maximum size subarray of A having only non-negative elements. If there are more than one such subarrays, return the one having earliest starting index in A.



Example Input
Input 1:

 A = [5, 6, -1, 7, 8]
Input 2:

 A = [1, 2, 3, 4, 5, 6]


Example Output
Output 1:

 [5, 6]
Output 2:

 [1, 2, 3, 4, 5, 6]


Example Explanation
Explanation 1:

 There are two subarrays of size 2 having only non-negative elements.
 1. [5, 6]  starting point  = 0
 2. [7, 8]  starting point  = 3
 As starting point of 1 is smaller, return [5, 6]
Explanation 2:

 There is only one subarray of size 6 having only non-negative elements:
 [1, 2, 3, 4, 5, 6] */

package ArrayInterviewQuestions;

public class MaximumPositivity{
    public static void main(String[] args) {
        int[] A = {1, 11, 2, 3, -15, 5, 6, -1, 7, 8};
        int[] subArr = solve(A);
        for (int i : subArr) {
            System.out.print(i + " ");
        }
    }
    /**
     * @param A: integer array
     * @return integer array : maximum sized positive subarray
     */
    public static int[] solve(int[] A) {
        int Idx = -1,MaxSize = 0;
        for(int i = 0; i<A.length;i++){
            int size = 0,idx=i;
            while(A[i]>=0){
                size++;
                i++;
                if(i>A.length-1){break;} // while loop should break after
                //the whole array is itreated.
            }
            if(size>MaxSize){
                Idx = idx;
                MaxSize = size;
            }
        }

        // Returning the max positive sub array
        int[] maxPosArr = new int[MaxSize];
        int index = 0;
        for(int j=Idx;j<Idx+MaxSize;j++){
            maxPosArr[index] = A[j];
            index++;
        }
        return maxPosArr;
    }
}