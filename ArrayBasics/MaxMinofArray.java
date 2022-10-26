/*Problem Description
Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
First argument A is an integer array.


Output Format
Return the sum of maximum and minimum element of the array


Example Input
Input 1:

A = [-2, 1, -4, 5, 3]
Input 2:

A = [1, 3, 4, 1]


Example Output
Output 1:

1
Output 2:

5


Example Explanation
Explanation 1:

Maximum Element is 5 and Minimum element is -4. (5 + (-4)) = 1. 
Explanation 2:

Maximum Element is 4 and Minimum element is 1. (4 + 1) = 5. */
package ArrayBasics;

import java.util.ArrayList;
import java.util.Arrays;
// returns sum of max and min of an array
public class MaxMinofArray {
    public static int solve(ArrayList<Integer> A) {
        int max = A.get(0);
        int min = A.get(0);
        for(int i =1; i<A.size();i++){
            if(A.get(i)>max){
                max=A.get(i);
            }
            if(A.get(i)<min){
                min=A.get(i);
            }
        }
        return max+min;
    }
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        int output = solve(array);
        System.out.println(output);
    }
}
