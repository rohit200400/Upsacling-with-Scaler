/*Problem Description
Given an integer array A of size N, find the first repeating element in it.

We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.

If there is no repeating element, return -1.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109



Input Format
The first and only argument is an integer array A of size N.



Output Format
Return an integer denoting the first repeating element.



Example Input
Input 1:

 A = [10, 5, 3, 4, 3, 5, 6]
Input 2:

 A = [6, 10, 5, 4, 9, 120]


Example Output
Output 1:

 5
Output 2:

 -1


Example Explanation
Explanation 1:

 5 is the first element that repeats
Explanation 2:

 There is no repeating element, output -1 */
package Hashing;

import java.util.HashMap;

public class FirstRepeatingElement {
    public static void main(String[] args) {
        int[] A = {10, 5, 3, 4, 3, 5, 6};
        System.out.println("First repeating element is " + solve(A));
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
        for(int i:A){
            if(freq.get(i)>1) return i;
        }
        return -1; // if no repetetion
    }
}
