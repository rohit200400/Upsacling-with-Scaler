/*Problem Description

You are given a matrix A, you have to return another matrix which is the transpose of A.

NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; Where 1 ≤ i ≤ col and 1 ≤ j ≤ row. The tranpose of a matrix switches the element at (i, j)th index to (j, i)th index, and the element at (j, i)th index to (i, j)th index.


Problem Constraints

1 <= A.size() <= 1000

1 <= A[i].size() <= 1000

1 <= A[i][j] <= 1000



Input Format

First argument is a 2D matrix of integers.



Output Format

You have to return the Transpose of this 2D matrix.



Example Input

Input 1:

A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
Input 2:

A = [[1, 2],[1, 2],[1, 2]]


Example Output

Output 1:

[[1, 4, 7], [2, 5, 8], [3, 6, 9]]
Output 2:

[[1, 1, 1], [2, 2, 2]]


Example Explanation

Explanation 1:

Cearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
 we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].
 */
package Two_Dimensional_Matrix;

public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4, 5},
                     {6, 7, 8, 9, 10},
                     {11,12,13,14,15},
                     {16,17,18,19,20},
                     {21,22,23,24,25}};

        int[][] tranposeMtrx = solve(A);

        for (int[] row : tranposeMtrx) {
            for (int elements : row) {
                System.out.print(elements + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solve(int[][] A) {
        int [][] transpose = new int [A[0].length][A.length];
        // col
        for(int c = 0 ; c < A[0].length ; c ++){ 
            //row
            for(int r = 0 ; r <A.length ; r ++){ 
                transpose[c][r] = A[r][c];
            }   
        }
        return transpose;
    }
}
