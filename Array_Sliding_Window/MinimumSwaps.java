/*Problem Description

Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

Note: It is possible to swap any two elements, not necessarily consecutive.



Problem Constraints

1 <= length of the array <= 100000
-109 <= A[i], B <= 109



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.



Output Format

Return the minimum number of swaps.



Example Input

Input 1:

 A = [1, 12, 10, 3, 14, 10, 5]
 B = 8
Input 2:

 A = [5, 17, 100, 11]
 B = 20


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 A = [1, 12, 10, 3, 14, 10, 5]
 After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 Now, all elements less than or equal to 8 are together.
Explanation 2:

 A = [5, 17, 100, 11]
 After swapping 100 and 11, A => [5, 17, 11, 100].
 Now, all elements less than or equal to 20 are together. */

package Array_Sliding_Window;
// find minimum number of swap required to bring all the numbers <= B together
public class MinimumSwaps {
    public static void main(String[] args) {
        
    }

    public int solve(int[] A, int B) {
        int ans = 100000;
        int GoodValues = 0 ;// count of values less than or equale to B
        int BadValues = 0 ; // count of values greater than B

        if(A.length == 0 && B == 0  ){
            ans = 0 ; 
        }
        else{
            // counting good values in the array
            for(int i = 0 ; i < A.length ; i ++){
                if (A[i]<= B){
                    GoodValues++; 
                }
            }
            // counting bad values in the range(0-goodValues)
            for(int i = 0 ; i < GoodValues ; i ++){
                if (A[i]> B){
                    BadValues++; 
                }
            }
            // calculating minimum swaps 
            ans = Math.min(ans,BadValues);

            // Using sliding window:
            // if last value is greater than B then number of swap will increase
            // if starting value is greater than B then number of swap will decrease
            // this loop will run till last element i.e. j value reaches to end of array
            // in every loop we are taking minimum number of swaps using Math.min function
            for(int i = 0 , j = GoodValues ; j < A.length ; i++ , j ++){
                    if(A[j]> B){
                    BadValues++;
                }
                if(A[i]> B){
                    BadValues--;
                }
                ans = Math.min(ans,BadValues);
            }
        }
            return ans ;
    }
}
