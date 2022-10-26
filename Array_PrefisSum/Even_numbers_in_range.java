/*Problem Description   
You are given an array A of length N and Q queries given by the 2D array B of size Q*2. Each query consists of two integers B[i][0] and B[i][1].
For every query, the task is to find the count of even numbers in the range A[B[i][0]…B[i][1]].


Problem Constraints
1 <= N <= 105
1 <= Q <= 105
1 <= A[i] <= 109
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
[1, 2]
Output 2:
[2, 1]


Example Explanation
For Input 1:
The subarray for the first query is [1, 2, 3] which contains 1 even number.
The subarray for the second query is [2, 3, 4, 5] which contains 2 even numbers.
For Input 2:
The subarray for the first query is [2, 1, 8, 3] which contains 2 even numbers.
The subarray for the second query is [8, 3, 9] which contains 1 even number. */
package Array_PrefisSum;

public class Even_numbers_in_range {
    public static int[] solve(int[] A, int[][] B) {
       
        //int N = A.length;
        int M = B.length;
        int [] C = new int [M];
        int count;
        int left = 0 , right = 0 ;
        for(int j = 0 ; j<M ; j++){
            count=0;
            left = B[j][0];
            right = B[j][1];
            for(int i=left ; i<=right ; i++){
                if(A[i]%2==0){
                    count++;
                }
                C[j]=count;
            }
        }
        return C;
    
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 1};
        int[][] B = {{1, 4},{2, 3}};
        int[] output = solve(A,B);
        for (int integer : output) {
            System.out.print(integer + " ");
        }
    }
}
