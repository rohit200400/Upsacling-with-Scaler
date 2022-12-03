/*Problem Description
You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]


Problem Constraints
1 <= N <= 103
1 <= A[i] <= 109


Input Format
First argument A is an array of integers.


Output Format
Return an integer.


Example Input
Input 1:
A = [1, 2, 4, 3]
Input 2:
A = [2, 1, 2, 3]


Example Output
Output 1:
2
Output 2:
1


Example Explanation
For Input 1:
The triplets that satisfy the conditions are [1, 2, 3] and [1, 2, 4].
For Input 2:
 
The triplet that satisfy the conditions is [1, 2, 3].*/

package ArrayInterviewQuestions;

public class CountingIncreasingTriplets {
    public static void main(String[] args) {
        int[] A = {1, 11, 2, 3, 15};
        int count = solve(A);
        System.out.println("Total number of triplets are " + count);
    }

    /**
     * @param A  : Array of integer
     * @return int :  count of total increasing triplets
     * Approach : taking every element as a center element and counting elements on left 
     * which are smaller than center element and elements on right which are greater than center element
     * Atlast taking product of left and right for each element.
     */
    public static int solve(int[] A) {
        //count of triplets as ans
        int ans = 0 ;

        // iterating through the whole array
        for(int i = 0 ; i < A.length ; i++){
             int left = 0 ;
             int right = 0 ;

             // checking legt side for smaller elements
            for(int j = 0 ; j<i ; j++){
                if(A[j]<A[i]){
                    left++;
                }
            }

            // checking right side for greater elements
            for(int j=i+1 ; j<A.length ; j++){
                if(A[i]<A[j]){
                    right++;
                }
                
            }

            // Updating count as the product of left and right
            ans = ans + (left*right);   
        }
       
     return ans ;
    }
}
