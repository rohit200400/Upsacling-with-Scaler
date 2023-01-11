/*Problem Description
Given an array A of N integers.

Find the length of the longest subarray in the array which sums to zero.


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
Single argument which is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:

 A = [1, -2, 1, 2]
Input 2:

 A = [3, 2, -1]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 [1, -2, 1] is the largest subarray which sums up to 0.
Explanation 2:

 No subarray sums up to 0. */
package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LongestSubarrayZeroSum {
    public static void main(String[] args) {
        int[] A = {1, -2, 1, 2};
        System.out.println("There are "+solve(A)+" elements in the longest zero sum sub array.");
    }
    public static int solve(int[] A) {
        int longestZero = 0;
        // Declaring pf array
        long[] pf = new long[A.length];
        // calculating values of  pf
        for(int i =0; i<A.length;i++){
            if(i==0) pf[i]=A[i];
            else pf[i] = pf[i-1] + A[i];
            // if pf is zreo means sum turns out to be zero
            if (pf[i]==0) longestZero = Math.max(longestZero,i+1);
        }
        // Declaring HashMap of element,ArrayList
        HashMap<Long,ArrayList<Integer>> freq = new HashMap<>();
        // calculating frequency of each elemnet in array
        for(int i = 0;i<pf.length;i++){
            //if in HashMap then add count
            if (freq.containsKey(pf[i])) {
                freq.get(pf[i]).add(i);
                // calculating the size of sub Array
                int max = Collections.max(freq.get(pf[i]));
                int min = Collections.min(freq.get(pf[i]));
                longestZero = Math.max(longestZero,(max-min));
            }
            //if not in HashMap add element with count 1
            else{
                freq.put(pf[i], new ArrayList<Integer>());
                freq.get(pf[i]).add(i);
            }
        }
        return longestZero;
    }
}
