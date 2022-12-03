/* Problem Description
You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.

Problem Constraints
1 <= A.size() <= 103

1 <= A[i].size() <= 103

0 <= A[i][j] <= 103



Input Format
First argument is a vector of vector of integers.(2D matrix).



Output Format
Return a vector of vector after doing required operations.



Example Input
Input 1:

[1,2,3,4]
[5,6,7,0]
[9,2,0,4]


Example Output
Output 1:

[1,2,0,0]
[0,0,0,0]
[0,0,0,0]


Example Explanation
Explanation 1:

A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.*/

package Two_Dimensional_Matrix;

public class RowToColumnZero {
public static void main(String[] args) {
    // Initiating the array
    int[][] A = {{1, 2, 3, 4, 5},
                     {6, 7, 8, 9, 0},
                     {11,12,13,14,15},
                     {16,0,18,19,20},
                     {21,22,23,24,25}};

    // calling  the function
    int[][] ans = solve(A);

    // Printing the array
    for (int[] row : ans) {
            for (int elements : row) {
                System.out.print(elements + " ");
            }
            System.out.println();
        }
}

    public static int[][] solve(int[][] A) {
        // declaring row flag array and column flag array
        int[] rowFlag = new int[A.length];
        int[] colFlag = new int[A[0].length];

        // Updating flag of row and column array if element of the array is zero
        for(int r = 0; r<A.length;r++){
           for(int c = 0; c<A[0].length; c++){
               if(A[r][c]== 0){
                   rowFlag[r] = 1;
                   colFlag[c] = 1;
                }
            }
        }

        // updating row as zero if flag is positive
        for(int i =0; i<rowFlag.length; i++){
            if(rowFlag[i]==1){
                for(int r = 0; r<A.length;r++){
                    A[i][r] = 0;
                }
            }
        }

        // updating column as zero if flag is positive
        for(int i =0; i<colFlag.length; i++){
            if(colFlag[i]==1){
                for(int c = 0; c<A[0].length;c++){
                    A[c][i] = 0;
                }
            }
        }
        return A;
    }
}
