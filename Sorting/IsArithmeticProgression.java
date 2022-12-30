/*Problem Description
Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.

A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.



Problem Constraints
2 <= N <= 105

-109 <= A[i] <= 109



Input Format
The first and only argument is an integer array A of size N.



Output Format
Return 1 if the array can be rearranged to form an arithmetic progression, otherwise return 0.



Example Input
Input 1:

 A = [3, 5, 1]
Input 2:

 A = [2, 4, 1]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
Explanation 2:

 There is no way to reorder the elements to obtain an arithmetic progression. */
package Sorting;

import java.util.Arrays;

public class IsArithmeticProgression {
    public static void main(String[] args) {
        int[] A = {1, 11, 2, 3, 15};
        String outputMsg = solve(A)==1? "Array is AP.":"Array is not AP";
        System.out.println(outputMsg);
    }
    public static int solve(int[] A) {
        // first sort array as AP is always sorted in asc or desc order
        Arrays.sort(A);
        // taking the diffrence
        int diff = A[0]-A[1];
        // checking diffrence between every consecitive element
        for(int i =0; i<A.length-1;i++){
            if(A[i]-A[i+1]!=diff) return 0;
        }
        return 1;
    }
}
