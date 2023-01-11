/*Problem Description
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [-1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The array has sum 0. */
package Hashing;

import java.util.HashMap;

public class SubArraywith0sum {
    public static void main(String[] args) {
        int[] A = {10, -5, -3, 4, -5, 5, 6};
        String outSstatement = solve(A)==0 ? "No subarray with sum zero." : "Array contains subarray with sum zero.";
        System.out.println(outSstatement);
    }

    public static int solve(int[] A) {
        // Declaring pf array
        long[] pf = new long[A.length];
        // calculating values of  pf
        for(int i =0; i<A.length;i++){
            if(i==0) pf[i]=A[i];
            else pf[i] = pf[i-1] + A[i];
            // if pf is zreo means sum turns out to be zero
            if (pf[i]==0) return 1;
        }
        // Declaring HashMap
        HashMap<Long,Integer> freq = new HashMap<>();
        // calculating frequency of each elemnet in array array
        for(long i:pf){
            //if already in HashMap then add count
            if(freq.containsKey(i)==true){
                int count  = freq.get(i)+1;
                freq.put(i,count);
            }
            //if not in HashMap add element with count 1
            else freq.put(i,1);
        }
        for(long i:pf){
            if(freq.get(i)>1) return 1;
        }
        return 0; // if no repetetion
    }
}
