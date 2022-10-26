/*Problem Description
Given an array A of N integers. Also given are two integers B and C. Reverse the array A in the given range [B, C]


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
0 <= B <= C <= N - 1


Input Format
The first argument A is an array of integer.
The second and third arguments are integers B and C


Output Format
Return the array A after reversing in the given range.


Example Input
Input 1:

A = [1, 2, 3, 4]
B = 2
C = 3
Input 2:

A = [2, 5, 6]
B = 0
C = 2


Example Output
Output 1:

[1, 2, 4, 3]
Output 2:

[6, 5, 2]


Example Explanation
Explanation 1:

We reverse the subarray [3, 4].
Explanation 2:

We reverse the entire array [2, 5, 6]. */

package ArrayBasics;
import java.util.ArrayList;
import java.util.Arrays;

public class ReversRange {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B, int C) {
        int mid = B + (C-B)/2;
        for(int i=B, j=C;i<=mid;i++,j--){
            int temp =A.get(i);
            A.set(i,A.get(j));
            A.set(j,temp);
        }
        return A;
    }
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        int start=1,end = 5;
        ArrayList<Integer> output = solve(array, start, end);
        for (Integer integer : output) {
            System.out.print(integer + " ");
        }
    }
}
