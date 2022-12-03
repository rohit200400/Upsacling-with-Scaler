/*Problem Description
You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.



Problem Constraints

1 <= A.size(), B.size() <= 1000

1 <= A[i].size(), B[i].size() <= 1000

1 <= A[i][j], B[i][j] <= 1000



Input Format

Two arguments are vectors of vector of integers representing matrix A. First 2 integers R, C are the number of rows and columns. Then R * C integers follow corresponding to the rowwise numbers in the 2D array



Output Format

You have to return a vector of vector of integers after doing required operations.



Example Input

Input 1:

3 3 1 2 3 4 5 6 7 8 9
3 3 9 8 7 6 5 4 3 2 1


Example Output

Output 1:

[[10, 10, 10], [10, 10, 10], [10, 10, 10]]


Example Explanation

Explanation 1:

A + B = [[1+9, 2+8, 3+7],[4+6, 5+5, 6+4],[7+3, 8+2, 9+1]] = [[10, 10, 10], [10, 10, 10], [10, 10, 10]]. */
package Two_Dimensional_Matrix;

public class Addthematrices {
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

        int[][] sumMtrx = solve(A,B);
        
        for (int[] row : sumMtrx) {
            for (int elements : row) {
                System.out.print(elements + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solve(int[][] A, int[][] B) {
        int[][] addition = new int[B.length][A[0].length];
        
        for(int r = 0; r<A.length;r++){
            for(int c = 0; c<A[r].length; c++){
                addition [r][c] = A[r][c]+ B[r][c];
            }
        }
        return addition;
    }
}
