/* Problem Description
You are given a function isalpha() consisting of a character array A.

Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.



Problem Constraints
1 <= |A| <= 105



Input Format
Only argument is a character array A.



Output Format
Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.



Example Input
Input 1:

 A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
Input 2:

 A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 All the characters are alphanumeric.
Explanation 2:

 All the characters are NOT alphabets i.e ('#').
*/
package strings;

public class Isalnum {
    public static void main(String[] args) {
        char[] A = {'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'};
        String outputMsg = solve(A)==1? "String is Alpha Numeric":"String is not Alpha Numeric";
        System.out.println(outputMsg);
    }
    public static int solve(char[] A) {

        for(int i=0;i<A.length;i++)
        {
            if(!((A[i]>='a' && A[i]<='z') || (A[i]>='A'&&A[i]<='Z') || (A[i]>='0' && A[i]<='9')))
          { 
               return 0;
          } 
        }
        return 1;
    }
}
