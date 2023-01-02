/*Problem Description
You are given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.


Problem Constraints
1 <= N <= 3 * 105



Input Format
The only argument given is string A.



Output Format
Return the string A after reversing the string word by word.



Example Input
Input 1:
    A = "the sky is blue"
Input 2:
    A = "this is ib"


Example Output
Output 1:
    "blue is sky the"
Output 2:
    "ib is this"    


Example Explanation
Explanation 1:
    We reverse the string word by word so the string becomes "blue is sky the".
Explanation 2:
    We reverse the string word by word so the string becomes "ib is this". */
package strings;

public class reverseString2 {
    public static void main(String[] args) {
        String A = "Rohit Chaudhary";
        System.out.println(solve(A));
    }
    public static String solve(String A) {
        // converting string to string array
        String[] strArr = A.split(" ");

        // swapping characters in array to reverse it
        for(int i =0,j=strArr.length-1;i<strArr.length/2;i++,j--){
            String temp  = strArr[i];
            strArr[i] = strArr[j];
            strArr[j] = temp;
        }

        //converting String array to single String
        String string = String.join(" ",strArr );
        return string; 
    }
}
