/*Problem Description
Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.

Note: Using the library sort function is not allowed.



Problem Constraints
1 <= N <= 1000000
0 <= A[i] <= 2


Input Format
First and only argument of input contains an integer array A.


Output Format
Return an integer array in asked order


Example Input
Input 1 :
    A = [0 1 2 0 1 2]
Input 2:

    A = [0]


Example Output
Output 1:
    [0 0 1 1 2 2]
Output 2:

    [0]


Example Explanation
Explanation 1:
    [0 0 1 1 2 2] is the required order. */
package Sorting;

public class SortbyColor {
    public static void main(String[] args) {
        int[] A = {0, 1, 2, 0, 1, 2, 0, 1, 2};
        System.out.println("Array A");
        for (int i : A) {
            System.out.print(i+" ");
        }
        int[] out  = sortColors(A);
        System.out.println("\nSorted array");
        for (int i : out) {
            System.out.print(i+" ");
        }
    }
    public static int[] sortColors(int[] A) {
        int low = 0,mid=0,temp =0,high = A.length-1;
        while(mid<=high){
            switch(A[mid]){
                case 0:{
                    // swaping low and mid
                    temp = A[low];
                    A[low] = A[mid];
                    A[mid] = temp;
                    mid++;low++;
                    break;
                }
                case 1:{
                    //increasing mid
                    mid++;
                    break;
                }
                case 2:{
                    temp = A[high];
                    A[high] = A[mid];
                    A[mid] = temp;
                    high--;
                    break;
                }
            }
        }
        return A;
    }
}
