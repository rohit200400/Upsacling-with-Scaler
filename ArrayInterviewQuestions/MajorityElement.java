/*Problem Description
Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.



Problem Constraints
1 <= N <= 5*105
1 <= num[i] <= 109


Input Format
Only argument is an integer array.


Output Format
Return an integer.


Example Input
[2, 1, 2]


Example Output
2


Example Explanation
2 occurs 2 times which is greater than 3/2. */
package ArrayInterviewQuestions;

public class MajorityElement {

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 1, 8, 3, 9};
        int spIdx = majorityElement(A);
        System.out.println("the majority element is "+spIdx);
    }

    public static int majorityElement(final int[] A) {

        if(A.length == 1 ){
            return A[0];
        }
        int count = 1 ; //count of majorityElement
        int majorityElement = A[0] ; // Majority element
        for (int i = 1; i<A.length; i++) {
            if(count==0){ //if there is no majority then Set it
                majorityElement = A[i];
                count++;
                continue;
            }
            if(A[i] == majorityElement){ // if element is same as majorityElement
                count++; // increase count
            }
            else{
                count--; // deleting the majority element and 
                // current element

            }
        }
        return majorityElement;
    }
}
