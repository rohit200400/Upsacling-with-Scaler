/* Problem Description
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.



Problem Constraints
1 <= A <= 1000



Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements added in spiral order.



Example Input
Input 1:

1
Input 2:

2
Input 3:

5


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2], [4, 3] ]
Output 2:

[ [1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9] ]


Example Explanation
Explanation 1:

Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3*/
package Array_Sliding_Window;

public class SpiralOrderMatrixII {
    public static void main(String[] args) {
        int[][] SpiralOrderMatrix = generateMatrix(5);

        for (int[] row : SpiralOrderMatrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param A = integer 
     * @return  = returns A spiral matrix generated with A^2 as center
     */
    public static int[][] generateMatrix(int A) {
        int[][] spiralMatrix = new int [A][A];
        int num = 1 ;
        int row = 0 ; 
        int col = 0 ;
        while(A>1){
            // top row left to right
            for(int c = 1 ; c <= A-1 ; c++){
                spiralMatrix[row][col] = num ;
                num++;
                col++;
            }
            //left column top to bottom
            for(int c = 1 ; c <= A-1 ; c++){
                spiralMatrix[row][col] = num ;
                num++;
            row++;
            }
            // lower row left to right
            for(int c = 1 ; c <= A-1 ; c++){
                spiralMatrix[row][col] = num ;
                num++;
                col--;
            }
            // right column bottom up
            for(int c = 1 ; c <= A-1 ; c++){
                spiralMatrix[row][col] = num ;
                num++;
                row--;
            }
            // changing the values to jump into inner layer
            A = A - 2;
            row++;
            col++; 
        }

        if(A==1){
            spiralMatrix[row][col] = num ;
        }

        return spiralMatrix;
    }
}
