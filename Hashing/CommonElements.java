/*Problem Description
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.


Problem Constraints
1 <= N, M <= 105

1 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.

Second argument is an integer array B of size M.



Output Format
Return an integer array denoting the common elements.



Example Input
Input 1:

 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:

 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output
Output 1:

 [1, 2, 2]
Output 2:

 [2, 10]


Example Explanation
Explanation 1:

 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:

 Elements (2, 10) appears in both the array. */
package Hashing;

import java.util.HashMap;

public class CommonElements {
    public static void main(String[] args) { 
        int[] A = {2, 1, 4, 10},  B = {3, 6, 2, 10, 10};
        int[] Output = solve(A, B);
        System.out.println("Common elements in both arrays are:");
        for (int i : Output) {
            System.out.print(i+" ");
        }
    }
    public static int[] solve(int[] A, int[] B) {
        int Count = 0;
        // Declaring HashMap
        HashMap<Integer,Integer> freqA = new HashMap<>();
        // calculating frequency of each elemnet in array array
        for(int i:A){
            //if already in HashMap then add count
            if(freqA.containsKey(i)){
                int count  = freqA.get(i)+1;
                freqA.put(i,count);
            }
            //if not in HashMap add element with count 1
            else {freqA.put(i,1);}
        }

        // Declaring HashMap
        HashMap<Integer,Integer> freqB = new HashMap<>();
        // calculating frequency of each elemnet in array array
        for(int i:B){
            //if already in HashMap then add count
            if(freqB.containsKey(i)){
                int count  = freqB.get(i)+1;
                freqB.put(i,count);
            }
            //if not in HashMap add element with count 1
            else {freqB.put(i,1);}
        }

        for(Integer key: freqA.keySet()){
            if(freqB.containsKey(key)){
                Count+= Math.min(freqA.get(key),freqB.get(key));
            }
        }
        int idx = 0;
        int[] commonArr = new int[Count];
        for(Integer key: freqA.keySet()){
            if(freqB.containsKey(key)){
                for(int i = 0;i<Math.min(freqA.get(key),freqB.get(key));i++){
                    commonArr[idx] = key;
                    idx++;
                }
            }
        }
        return commonArr;
    }
}
