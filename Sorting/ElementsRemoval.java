/*Problem Description
Given an integer array A of size N. You can remove any element from the array in one operation.
The cost of this operation is the sum of all elements in the array present before this operation.

Find the minimum cost to remove all elements from the array.



Problem Constraints
0 <= N <= 1000
1 <= A[i] <= 103



Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the total cost of removing all elements from the array.



Example Input
Input 1:

 A = [2, 1]
Input 2:

 A = [5]


Example Output
Output 1:

 4
Output 2:

 5


Example Explanation
Explanation 1:

 Given array A = [2, 1]
 Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
 Remove 1 from the array => []. Cost of this operation is (1) = 1.
 So, total cost is = 3 + 1 = 4.
Explanation 2:

 There is only one element in the array. So, cost of removing is 5. */
package Sorting;

public class ElementsRemoval {
    public static void main(String[] args) {
        int[] A = {1, 11, 2, 3, 15};
        System.out.println("Total cost of removing all elements from array is " +solve(A));
    }
    public static int solve(int[] A) {
        // sort the array
        for (int i =0; i<A.length;i++){
            for(int j = 0;j<A.length-i-1;j++){
                if(A[j]>A[j+1]){
                    //Swap
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        //print sorted array
        // for(int element : A){
        //     System.out.print( element + " ");
        // }
        // return the sum of pfSum of array
        int sum = 0;
        
        for(int i=0;i<A.length;i++)
        {
            sum += (A.length-i)*A[i];
        }
        return sum;
    }
}
