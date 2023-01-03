/*Problem Description
You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.

Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.


Problem Constraints
1 <= N <= 105
A and B are lowercase strings


Input Format
Both arguments A and B are a string.


Output Format
Return 1 if they are anagrams and 0 if not


Example Input
Input 1:
A = "cat"
B = "bat"
Input 2:
A = "secure"
B = "rescue"


Example Output
Output 1:
0
Output 2:
1


Example Explanation
For Input 1:
The words cannot be rearranged to form the same word. So, they are not anagrams.
For Input 2:
They are an anagram. */
package strings;

import java.util.Arrays;

public class CheckAnagrams {
    public static void main(String[] args) {
        String A = "cat",B = "act";
        String outputMsg = solve(A, B)==0? "Given strings are not anagrams.":"Given strings are anagrams.";
        System.out.println(outputMsg);
    }
    public static int solve(String A, String B) {
        char ch1[] = A.toCharArray();
        char ch2[] = B.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        boolean result = (Arrays.equals(ch1, ch2));
        if(result==false){
            return 0;
        }
        else{
            return 1;
        }
    }
}
