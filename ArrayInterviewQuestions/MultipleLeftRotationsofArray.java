/*Problem Description
Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.

Find the rotated array for each value and return the result in the from of a matrix where ith row represents the rotated array for the ith value in B.



Problem Constraints
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000


Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.


Output Format
Return the resultant matrix.


Example Input
Input 1:
 
    A = [1, 2, 3, 4, 5]
    B = [2, 3]

Input 2:

  
    A = [5, 17, 100, 11]
    B = [1]




Example Output
Output 1:
 
    [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]


Output 2:

    
    [ [17, 100, 11, 5] ]



Example Explanation
for input 1 -> B[0] = 2 which requires 2 times left rotations

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

B[1] = 3 which requires 3 times left rotation

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

2: [4, 5, 1, 2, 4] */
package ArrayInterviewQuestions;

public class MultipleLeftRotationsofArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int rotationTimes = 3;
        //Printing rotated array
        int[] rotatedArr = solve(A, rotationTimes);
        for (int i : rotatedArr) {
            System.out.print(i + " ");
        }
    }

    /**
     * @param A : int Array
     * @param B : int number of times array need to be rotated
     * @return  : rotated int Array 
     */
    public static int[] solve(int[] A, int B) {
        int[] rotatedArr = new int[A.length];
        int rotation = B;
            int idx = 0;
            if(rotation !=0){
                for(int start = rotation; start<A.length;start++){
                    rotatedArr[idx] = A[start];
                    idx++;
                }
                for(int end = 0; end < rotation;end++){
                    rotatedArr[idx] = A[end];
                    idx++;
                }
            }
            else{
                for(int j =0; j<A.length;j++){
                    rotatedArr[j] = A[j];
                }
            }
        
        return rotatedArr;
    }
}
