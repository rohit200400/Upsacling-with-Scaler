/*Problem Description
You are given an array A of N integers. You will have to return number of distinct elements of the array.


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
3
Output 2:
4


Example Explanation
For Input 1:
The distinct elements of the array are 3, 4 and 6.
For Input 2:
The distinct elements of the array are 3, 9, 0 and 1. */
package Hashing;

import java.util.HashMap;

public class Countdistinctelements {
    public static void main(String[] args) {
        int[] A = {3, 3, 3, 9, 0, 1, 0};
        System.out.println("Distinct elements of the array are " + solve(A));
    }
    public static int solve(int[] A) {
        // Declaring HashMap
        HashMap<Integer,Integer> freq = new HashMap<>();
        // calculating frequency of each elemnet in array array
        for(int i:A){
            //if already in HashMap then add count
            if(freq.containsKey(i)==true){
                int count  = freq.get(i)+1;
                freq.put(i,count);
            }
            //if not in HashMap add element with count 1
            else freq.put(i,1);
        }
        // Size of hashSet is the number of distinct elements array A contains
        return freq.size();
    }
}
