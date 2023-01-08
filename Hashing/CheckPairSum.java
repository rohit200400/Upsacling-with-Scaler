/*Problem Description
Given an Array of integers B, and a target sum A.
Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.


Problem Constraints
1<= Length of array B <= 103
0<= Bi <=109
0<= A <=109


Input Format
First argument A is the Target sum, and second argument is the array B


Output Format
Return an integer value 1 if there exists such pair, else return 0.


Example Input
Input 1:

A = 8   B = [3, 5, 1, 2, 1, 2]
Input 2:

A = 21   B = [9, 10, 7, 10, 9, 1, 5, 1, 5]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
In Example 1:
It is possible to obtain sum 8 using 3 and 5. */
package Hashing;

import java.util.HashMap;

public class CheckPairSum {
    public static void main(String[] args) {
        int targerSum = 8 ;
        int[]  array = {3, 5, 1, 2, 1, 2};
        //int targerSum = 21 ;
        //int[]  array = {9, 10, 7, 10, 9, 1, 5, 1, 5};
        System.out.println(solve(targerSum, array)==1?"Pair exists.":"Pair dosen't exists.");
    }
    public static int solve(int A, int[] B) {
        // Declaring HashMap
        HashMap<Integer,Integer> freq = new HashMap<>();
        // calculating frequency of each elemnet in array array
        for(int i:B){
            //if already in HashMap then add count
            if(freq.containsKey(i)==true){
                int count  = freq.get(i)+1;
                freq.put(i,count);
            }
            //if not in HashMap add element with count 1
            else freq.put(i,1);
        }
        // Pair Sum code
        for(int i =0; i<B.length;i++){
            if((A-B[i])==B[i] ) {
                if(freq.get(B[i])>1){
                    return 1;
                }
            }
            else{
                if(freq.containsKey(A-B[i])) return 1;
            }
        }
        return 0;
    }
}
