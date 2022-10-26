/*Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.



Problem Constraints
1 <= |A| <= 2000



Input Format
First and only argument is vector A



Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array



Example Input
Input 1:

A = [1, 3]
Input 2:

A = [2]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 Only choice is to take both elements.
Explanation 2:

 Take the whole array. */
package ArrayCarryForward;

public class ClosestMinMax {
    public static int solve(int[] A) {

        /*Declaring Global Variablres*/
        int max = 0; //Max element
        int min = 2001; // Min element
        int N = A.length; // size of the array
        int shortestLength = A.length; // output variable: initiation as max possible
        
        /*  searching Max and min from the array
            Time taken = O(N)
            Space taken = O(1)
        */
        for(int i=0 ; i<N ; i++){
            if(A[i]>max){
                max = A[i];
            }
            if(A[i]<min){
                    min = A[i];
                }
        }

    // Logic for checking the smallest subarray containing max and min
        //First condition is applicable if size of array is 1 OR
        //all the elements of array are same.
        if(max==min) return 1;

        for(int i =0;i<A.length;i++){
            if(A[i]==max){
                for(int j=i+1 ; j<N ; j++){
                    if(A[j]==max){
                        break;
                    }
                    if(A[j]==min){
                        int length = j-i+1;
                        shortestLength = Math.min(shortestLength,length);
                        break;
                    }
                }
                for(int j=i-1 ; j>=0 ; j--){
                    if(A[j]==max){
                        break;
                    }
                    if(A[j]==min){
                        int length = i-j+1;
                        shortestLength = Math.min(shortestLength,length);
                        break;
                    }
                }
            }
        }
        return shortestLength;  
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 1};
        int output = solve(A);
        System.out.println(output);
    }
}
