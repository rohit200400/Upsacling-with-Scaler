/*Problem Description
You are given a 2D integer matrix A, return a 1D integer array containing row-wise sums of original matrix.



Problem Constraints

1 <= A.size() <= 103

1 <= A[i].size() <= 103

1 <= A[i][j] <= 103



Input Format
First argument A is a 2D array of integers.(2D matrix).



Output Format
Return an array conatining row-wise sums of original matrix.



Example Input
Input 1:

[1,2,3,4]
[5,6,7,8]
[9,2,3,4]


Example Output
Output 1:

[10,26,18] */

package Two_Dimensional_Matrix;

public class RowSum {
    public static void main(String[] args) {
        // initializing a 2D matrix
        int[][] A = {{1, 2, 3, 4, 5},
                     {6, 7, 8, 9, 10},
                     {11,12,13,14,15},
                     {16,17,18,19,20},
                     {21,22,23,24,25}};

        int[] rowSum = solve(A);
        for (int i : rowSum) {
            System.out.println(i);
        }
    }
    public static int[] solve(int[][] A) {
        int[] rowsum = new int [A.length];
        for(int r = 0 ; r < A.length ; r++){
            int sum = 0 ; 
            for (int c = 0 ; c < A[r].length ; c++){
                sum += A[r][c]; 
            }
            rowsum[r] = sum ;
        }
        return rowsum ;
    }
}
