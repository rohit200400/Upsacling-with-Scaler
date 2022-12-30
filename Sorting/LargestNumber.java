/*Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format
The first argument is an array of integers.



Output Format
Return a string representing the largest number.



Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */
package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int[] A = {6, 8, 9};
        String number = largestNumber (A);
        System.out.println(number);
    }
    public static String largestNumber(final int[] A) {
        ArrayList<String> arrList = new ArrayList<String>();
        int sum = 0;
        int n = A.length;
        for(int i=0;i<n;i++) {
            arrList.add(Integer.toString(A[i]));
            sum = sum + A[i];
        }
        if (sum == 0) {
            return "0";
        }
        Collections.sort(arrList, new Comparator<String>(){
            public int compare(String a, String b){
                String firstNum = a+b;
                String secondNum = b+a;
                return firstNum.compareTo(secondNum) > 0 ? -1 : 1;
            }
        });
        
        String result = String.join("", arrList);
        return result;
    }
}
