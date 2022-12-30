/*Problem Description
Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.



Problem Constraints
1 <= |A| <= 2*105
-108 <= A[i] <= 108


Input Format
First and only argument is an integer array A.



Output Format
Return 1 if any such integer p is present else, return -1.



Example Input
Input 1:

 A = [3, 2, 1, 3]
Input 2:

 A = [1, 1, 3, 3]


Example Output
Output 1:

 1
Output 2:

 -1


Example Explanation
Explanation 1:

 For integer 2, there are 2 greater elements in the array..
Explanation 2:

 There exist no integer satisfying the required conditions. */
package Sorting;

import java.util.Arrays;

public class NobleInteger {
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 3};
        int out = solve(A);
        String output = out==-1?"There are no Noble Integer in the array.":("Total noble elements in the array are " + out);
        System.out.println(output);
    }
    public static int solve(int[] A) {
        // sort the array
        Arrays.sort(A);
        
        int nobelCnt = 0;
        for (int i =0; i<A.length;i++){
            if(((i+1)<(A.length))&&(A[i]==A[i+1])){
                continue;
            }
            if(A[i]==A.length-i-1) nobelCnt++;
        }
        if(nobelCnt==0) return -1;
        return 1;
    }
}
