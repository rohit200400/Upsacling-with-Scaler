/*Problem Description
Given an array A. You have some queries given by the array B.

For the i-th query, find the frequency of B[i] in the array A.



Problem Constraints
1 <= |A| <= 105

1 <= |B| <= 105

1 <= A[i] <= 105

1 <= B[i] <= 105



Input Format
First argument A is an array of integers.

Second argument B is an array of integers denoting the queries.



Output Format
Return an array of integers answering each of the queries.



Example Input
Input 1:
A = [1, 2, 1, 1]
B = [1, 2]
Input 2:
A = [2, 5, 9, 2, 8]
B = [3, 2]


Example Output
Output 1:
[3, 1]
Output 2:
[0, 2]


Example Explanation
For Input 1:
The frequency of 1 in the array A is 3.
The frequency of 2 in the array A is 1.
For Input 2:
The frequency of 3 in the array A is 0.
The frequency of 2 in the array A is 2.
 */
package Hashing;

import java.util.HashMap;

public class Frequencyofelement {
    public static void main(String[] args) {
        int[] A = {2, 5, 9, 2, 8},B = {3, 2};
        System.out.print("Integers:  ");
        for (int i : B) {
            System.out.print(i+" ");
        }
        System.out.print("\nFrequency: ");
        int[] freq = solve(A, B);
        for (int i : freq) {
            System.out.print(i+" ");
        }
    }
    public static int[] solve(int[] A, int[] B) {
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
            else {freq.put(i,1);}
        }
        // creating an output list
        int[] output = new int[B.length];
        //checking the freq of each element in B in the hashset
        for(int i =0; i<B.length;i++){
            if(freq.containsKey(B[i])==true){
                output[i] = freq.get(B[i]);
            }
            else output[i] = 0;
        }
        return output;
    }
}
