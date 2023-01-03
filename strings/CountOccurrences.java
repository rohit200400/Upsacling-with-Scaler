/*Problem Description
Find the number of occurrences of bob in string A consisting of lowercase English alphabets.



Problem Constraints
1 <= |A| <= 1000


Input Format
The first and only argument contains the string A, consisting of lowercase English alphabets.


Output Format
Return an integer containing the answer.


Example Input
Input 1:

  "abobc"
Input 2:

  "bobob"


Example Output
Output 1:

  1
Output 2:

  2


Example Explanation
Explanation 1:

  The only occurrence is at second position.
Explanation 2:

  Bob occures at first and third position. */
package strings;

public class CountOccurrences {
    public static int solve(String A) {
        int count = 0;
        while (A.indexOf("bob") != -1) {
            int index = A.indexOf("bob");
            A = A.substring(index + 2, A.length());
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String A = "bobobobob";
        System.out.println("There are total "+solve(A)+" occurrences of 'bob' in the given string.");
    }
}
