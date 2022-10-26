/*Problem Description
Given an array A of N integers. Construct prefix sum of the array in the given array itself.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 103


Input Format
Only argument A is an array of integers.


Output Format
Return an array of integers denoting the prefix sum of the given array.


Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [4, 3, 2]


Example Output
Output 1:

[1, 3, 6, 10, 15]
Output 2:

[4, 7, 9] */
package Array_PrefisSum;

public class In_placePrefixSum {
    public static int[] solve(int[] A) {
        for(int i = 1; i<A.length; i++){
            A[i]+=A[i-1];
        }
        return A;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] output = solve(A);
        for (int integer : output) {
            System.out.print(integer + " ");
        }
    }
}
