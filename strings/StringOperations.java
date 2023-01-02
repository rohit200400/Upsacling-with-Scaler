/*Problem Description

Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:

Concatenate the string with itself.
Delete all the uppercase letters.
Replace each vowel with '#'.
You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.

NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.



Problem Constraints

1<=N<=100000


Input Format

First argument is a string A of size N.



Output Format

Return the resultant string.



Example Input

A="AbcaZeoB"



Example Output

"bc###bc###"



Example Explanation

First concatenate the string with itself so string A becomes "AbcaZeoBAbcaZeoB".
Delete all the uppercase letters so string A becomes "bcaeobcaeo".
Now replace vowel with '#'.
A becomes "bc###bc###". */
package strings;

public class StringOperations {
    public static void main(String[] args) {
        String A = "AbcaZeoB";
        System.out.println(solve(A));
    }
    public static  String solve(String A) {
        String strNew = A.replaceAll("([A-Z])", "");
        // deleting all UpperCase
        StringBuilder str = new StringBuilder(strNew);
        
        str = str.append(str);
        // Appending string
        for(int i=0; i<str.length(); i++){
        if(str.charAt(i)=='a' || str.charAt(i)=='e'
        || str.charAt(i)=='i' || str.charAt(i)=='o'
        || str.charAt(i)=='u'){
        str.setCharAt(i,'#'); //converting to '#'
        }
        }
        return str.toString();
        }
}
