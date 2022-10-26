/*You are given a string S, and you have to find all the amazing substrings of S.

An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
Example

Input
    ABEC

Output
    6

Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6. */
package ArrayCarryForward;

public class AmazingSubarrays {
    public static int solve(String A) {
        int count = 0;
        for(int i=0;i<A.length();i++){
            char x = A.charAt(i);
            if(x=='a'||x=='e'|| x=='i'||x=='o'||x=='u'||x=='A'||
            x=='E'|| x=='I'||x=='O'||x=='U'){
                count= (count+A.length()-i)%10003;
            }
        }
        return (int)count%10003;
    }
    public static void main(String[] args) {
        String A = "cainffoanpflmawfnananfaeiou";
        int output = solve(A);
        System.out.println(output);
    }
}
