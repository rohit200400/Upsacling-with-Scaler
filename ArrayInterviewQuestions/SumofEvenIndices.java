/*Problem Description
You are given an array A of length N and Q queries given by the 2D array B of size Q*2. Each query consists of two integers B[i][0] and B[i][1].
For every query, the task is to calculate the sum of all even indices in the range A[B[i][0]…B[i][1]].

Note : Use 0-based indexing


Problem Constraints
1 <= N <= 105
1 <= Q <= 105
1 <= A[i] <= 100
0 <= B[i][0] <= B[i][1] < N


Input Format
First argument A is an array of integers.
Second argument B is a 2D array of integers.


Output Format
Return an array of integers.


Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = [   [0,2] 
        [1,4]   ]
Input 2:
A = [2, 1, 8, 3, 9]
B = [   [0,3] 
        [2,4]   ]


Example Output
Output 1:
[4, 8]
Output 2:
[10, 17]


Example Explanation
For Input 1:
The subarray for the first query is [1, 2, 3] whose sum of even indices is 4.
The subarray for the second query is [2, 3, 4, 5] whose sum of even indices is 8.
For Input 2:
The subarray for the first query is [2, 1, 8, 3] whose sum of even indices is 10.
The subarray for the second query is [8, 3, 9] whose sum of even indices is 17.
 */

package ArrayInterviewQuestions;

public class SumofEvenIndices {

    public static void main(String[] args) {
        int[] A = {2, 1, 8, 3, 9};
        int[][] B = {{0,3},{2,4}};
        int[] sumArr = solve(A, B);
        for (int i : sumArr) {
            System.out.println("Sum of even element are " + i);
        }
    }
    public static int[] solve(int[] A, int[][] B) {
        int[] prefixEvenSum = new int[A.length];
        //generating prefix array of even number
        int sum = 0;
        for(int i=0;i<A.length;i++){
            if(i%2==0){
                sum+=A[i];
                prefixEvenSum[i] = sum;
            }
            else{
                prefixEvenSum[i] = sum;
            }
        }
        // intitating output array
        int[] evenSum = new int[B.length];
        for(int i =0; i<B.length;i++){
            if(B[i][0]==0){evenSum[i] = prefixEvenSum[B[i][1]];}
            else {evenSum[i] = prefixEvenSum[B[i][1]] - prefixEvenSum[B[i][0]-1];}
        }
        return evenSum;
    }
}
