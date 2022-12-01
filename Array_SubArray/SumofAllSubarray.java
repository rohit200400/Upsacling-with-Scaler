/*Problem Description
You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.



Problem Constraints
1 <= N <= 105
1 <= Ai <= 10 4


Input Format
The first argument is the integer array A.


Output Format
Return a single integer denoting the sum of all subarray sums of the given array.


Example Input
Input 1:
A = [1, 2, 3]
Input 2:

A = [2, 1, 3]


Example Output
Output 1:
20
Output 2:

19


Example Explanation
Explanation 1:
The different subarrays for the given array are: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3].
Their sums are: 1 + 2 + 3 + 3 + 5 + 6 = 20
Explanation 2:

Similiar to the first example, the sum of all subarray sums for this array is 19. */

package Array_SubArray;

public class SumofAllSubarray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 1};
        long sum = subarraySum(A);
        System.out.println(sum);
    }

    public static long subarraySum(int[] A) {
        long ans = 0 ; 
        for(int i = 0 ; i < A.length ; i ++){
           ans +=  (long)A[i] *(A.length - i )*(i + 1);
        }
        return ans ;
    }
}
