/*Problem Description
You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109


Input Format
First argument A is an array of integers.


Output Format
Return an integer.


Example Input
Input 1:
A = [3, 4, 3, 6, 6]
Input 2:
A = [3, 3, 3, 9, 0, 1, 0]


Example Output
Output 1:
1
Output 2:
2


Example Explanation
For Input 1:
Only the element 4 has a frequency 1.
For Input 2:
The elements 9 and 1 has a frequncy 1. */
package Hashing;

import java.util.HashMap;

public class CountUniqueElements {
    public static void main(String[] args) {
        int[] A = {3, 3, 3, 9, 0, 1, 0};
        System.out.println("Unique number of element in the array are "+solve(A));
    }
    public static int solve(int[] A) {

        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int count = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (myMap.containsKey(A[i])) {
                int val = myMap.get(A[i]);
                myMap.put(A[i], ++val);
                if (val == 2) {
                    count--; // Decrement the counter on first repetition
                }
            } 
            else {
                myMap.put(A[i], 1);
                count++; // increment the counter on first occurrence
            }
        }
        
        return count;
    }
}
