/*Problem Description

Given an integer array A containing N distinct integers, you have to find all the leaders in array A.

An element is a leader if it is strictly greater than all the elements to its right side.

NOTE:The rightmost element is always a leader.



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 108



Input Format

First and only argument is an integer array A.



Output Format

Return an integer array denoting all the leader elements of the array.

NOTE: Ordering in the output doesn't matter.



Example Input

Input 1:

 A = [16, 17, 4, 3, 5, 2]
Input 2:

 A = [1, 2]


Example Output

Output 1:

 [17, 2, 5]
Output 2:

 [2]


Example Explanation

Explanation 1:

 Element 17 is strictly greater than all the elements on the right side to it.
 Element 2 is strictly greater than all the elements on the right side to it.
 Element 5 is strictly greater than all the elements on the right side to it.
 So we will return this three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.
Explanation 2:

 Only 2 the rightmost element is the leader in the array. */
package ArrayCarryForward;

public class LeadersinArray {
    public static int[] solve(int[] A) {
        int N = A.length;
        int[] leaders = new int[N];
        int max = 0,leadersIdx = 0; // max
        for(int index = N-1 ; index >= 0 ; index--){
            if(A[index]>max){
                max = A[index];
                leaders[leadersIdx] = max;
                leadersIdx++;
            }
        }  
        int[] leadersNew = new int[leadersIdx];
        for(int i =0;i<leadersIdx;i++){
            leadersNew[i] = leaders[i];
        }
        return leadersNew ;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 1};
        int[] output = solve(A);
        for (int integer : output) {
            System.out.print(integer + " ");
        }
    }
}
