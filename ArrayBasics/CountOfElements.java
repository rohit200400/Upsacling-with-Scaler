package ArrayBasics;

import java.util.Scanner;

/*Problem Description
Given an array A of N integers. Count the number of elements that have at least 1 elements greater than itself.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109


Input Format
First and only argument is an array of integers A.


Output Format
Return the count of elements.


Example Input
Input 1:
A = [3, 1, 2]
Input 2:
A = [5, 5, 3]


Example Output
Output 1:
2
Output 2:
1


Example Explanation
Explanation 1:
The elements that have at least 1 element greater than itself are 1 and 2
Explanation 2:
The elements that have at least 1 element greater than itself is 3 */

public class CountOfElements {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in); //Declaring Scanner object
        System.out.println("Input number of elememts in the array\n"); 
        int n = Scan.nextInt();    //getting input from console
        int[] array = new int[n];
        System.out.println("Input of elememts in the array, one in a line\n"); 
        for (int index = 0; index < n; index++) {
            array[index] = Scan.nextInt();
        }
        Scan.close();   //closing scanner
        System.out.println("Second highest number is "+solve(array));
        
    }
    /**
     * @param A is an array of integer 
     * @return the function returns Second highest number in the Array
     */
    public static int solve(int[] A) {
        int max = A[0];
        int maxCount = 1;
        for(int i=0;i<A.length;i++){
            if(A[i]>max) {
                max=A[0]; 
                maxCount=1;
            }
            if(A[i]==max) maxCount++;
        }
        return A.length- maxCount;
    }
}
