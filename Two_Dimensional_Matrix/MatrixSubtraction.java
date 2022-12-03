/*Problem Description

You are given two integer matrices A and B having same size(Both having same number of rows (N) and columns (M). You have to subtract matrix B from A and return the resultant matrix. (i.e. return the matrix A - B).

If A and B are two matrices of the same order (same dimensions). Then A - B is a matrix of the same order as A and B and its elements are obtained by doing an element wise subtraction of A from B.


Problem Constraints

1 <= N, M <= 103

-109 <= A[i][j], B[i][j] <= 109



**Input Format**
There are 2 lines in the input
Line 1 ( Corresponds to arg 1 ) : 2 D array. First 2 integers R, C are the number of rows and columns. Then R * C integers follow corresponding to the rowwise numbers in the 2D array.
Line 2 ( Corresponds to arg 2 ) : 2 D array. First 2 integers R, C are the number of rows and columns. Then R * C integers follow corresponding to the rowwise numbers in the 2D array.


Output Format

Return a 2D matrix denoting A - B.



Example Input

Input 1:

3 3 1 2 3 4 5 6 7 8 9
3 3 9 8 7 6 5 4 3 2 1
Input 2:

1 2 1 1 
1 2 2 


Example Output

Output 1:

 [[-8, -6, -4],
  [-2, 0, 2],
  [4, 6, 8]]
Output 2:

 [[-1, -2]]


Example Explanation

Explanation 2:

 [[1, 1]] - [[2, 3]] = [[1 - 2, 1 - 3]] = [[-1, -2]] */
package Two_Dimensional_Matrix;

public class MatrixSubtraction {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4, 5},
                     {6, 7, 8, 9, 10},
                     {11,12,13,14,15},
                     {16,17,18,19,20},
                     {21,22,23,24,25}};
        int[][] B = {{1, 2, 3, 4, 5},
                     {6, 7, 8, 9, 10},
                     {11,12,13,14,15},
                     {16,17,18,19,20},
                     {21,22,23,24,25}};

        int[][] diffMtrx = solve(A,B);
        
        for (int[] row : diffMtrx) {
            for (int elements : row) {
                System.out.print(elements + " ");
            }
            System.out.println();
        }
    }
    
    public static int[][] solve(int[][] A, int[][] B) {
        int[][] subtraction = new int[B.length][A[0].length];
       
       for(int r = 0; r<A.length;r++){
           for(int c = 0; c<A[r].length; c++){
               subtraction [r][c] = A[r][c]- B[r][c];
           }
       }
       return subtraction;
   }
}
