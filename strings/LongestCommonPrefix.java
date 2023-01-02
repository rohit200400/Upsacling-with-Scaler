/*Problem Description
Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.

The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Problem Constraints
0 <= sum of length of all strings <= 1000000



Input Format
The only argument given is an array of strings A.



Output Format
Return the longest common prefix of all strings in A.



Example Input
Input 1:

A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:

A = ["abab", "ab", "abcd"];


Example Output
Output 1:

"a"
Output 2:

"ab"


Example Explanation
Explanation 1:

Longest common prefix of all the strings is "a".
Explanation 2:

Longest common prefix of all the strings is "ab".
 */
package strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] A = {"abcdefgh", "aefghijk", "abcefgh"};
        System.out.println(longestCommonPrefix(A));

    }
    public static String longestCommonPrefix(String[] A) {
        int end=0;
        // for each element 
        for(int i =0;i<A[0].length();i++){
            int flag = 1;
            char first = A[0].charAt(i);
            //foreach string in array A
            for(String str:A){
                // if char at ith idx is not same for all strings
                // then break from this loop
                if( str.length() <= i || first!=str.charAt(i)){
                    flag *=0; // if char is not same update flag as 0
                    break;
                }
            }
            // if flag is 0 then break from this loop
            if(flag==0)break;
            end++;
        }
        return A[0].substring(0,end);
    }
}
