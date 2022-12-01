/*Problem Description
You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.



Problem Constraints
1 <= A.size() <= 103

1 <= A[i].size() <= 103

1 <= A[i][j] <= 103



Input Format
First argument is a 2D array of integers.(2D matrix).



Output Format
Return an array conatining column-wise sums of original matrix.



Example Input
Input 1:

[1,2,3,4]
[5,6,7,8]
[9,2,3,4]


Example Output
Output 1:

{15,10,13,16}


Example Explanation
Explanation 1

Column 1 = 1+5+9 = 15
Column 2 = 2+6+2 = 10
Column 3 = 3+7+3 = 13
Column 4 = 4+8+4 = 16 */

package Two_Dimensional_Matrix;

public class ColumnSum {
    public static void main(String[] args) {
        // initializing a 2D matrix
        int[][] A = {{1, 2, 3, 4, 5},
                     {6, 7, 8, 9, 10},
                     {11,12,13,14,15},
                     {16,17,18,19,20},
                     {21,22,23,24,25}};

        int[] colSum = solve(A);
        for (int i : colSum) {
            System.out.print(i  + " ");
        }

    }
    public static int[] solve(int[][] A) {

        int[] clmSum = new int[A[0].length];

        for(int c =0;c<A[0].length;c++){
            int sum =0;
            for(int r=0; r<A.length;r++){
                sum+=A[r][c];
            }
            clmSum[c] = sum;
        }
        
        return clmSum;
    }
}
