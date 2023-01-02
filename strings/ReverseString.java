/*Problem Description
Given a string A, you are asked to reverse the string and return the reversed string.



Problem Constraints
1 <= |A| <= 105

String A consist only of lowercase characters.



Input Format
First and only argument is a string A.



Output Format
Return a string denoting the reversed string.



Example Input
Input 1:

 A = "scaler"
Input 2:

 A = "academy"


Example Output
Output 1:

 "relacs"
Output 2:

 "ymedaca"


Example Explanation
Explanation 1:

 Reverse the given string. */
package strings;

public class ReverseString {
    public static void main(String[] args) {
        String A = "Rohit Chaudhary";
        System.out.println(solve(A));
    }
    public static String solve(String A) {
        // converting string to char array
        char[] charArr = A.toCharArray();

        // swapping characters in array to reverse it
        for(int i =0,j=charArr.length-1;i<charArr.length/2;i++,j--){
            char temp  = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
        }

        //converting Char array to String
        String string = new String(charArr);
        return string; 
    }
}
