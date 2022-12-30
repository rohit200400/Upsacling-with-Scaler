/*Problem Description
You are given a number A in the form of a string. Check if the number is divisible by eight or not.

Return 1 if it is divisible by eight else, return 0.


Problem Constraints
1 <= length of the String <= 100000
'0' <= A[i] <= '9'


Input Format
The only argument given is a string A.


Output Format
Return 1 if it is divisible by eight else return 0.


Example Input
Input 1:
A = "16"
Input 2:

A = "123"


Example Output
Output 1:
1
Output 2:

0


Example Explanation
Explanation 1:
 16 = 8 * 2
Explanation 2:

123 = 15 * 8 + 3 */
package ModularAirthematic;

public class Divisibilityby8 {
    public static void main(String[] args) {
        String number = "12320";
        String divsibility = solve(number)==1? "Integer is divisible by 8" : "Integer is not divisible by 8";
        System.out.println(divsibility);
    }

    public static int solve(String A) {
        int t=1,B=8;//B is the divisor, t is the place value of digits
        int rem=0; // remainder
        for(int i=A.length()-1;i>=0;i--){
            rem+=((((int)(A.charAt(i))%B)*t)%B); //adding to remainder
            t=(t*10)%B; //increasing place value
        }
        if(rem%B==0)return 1;// if remainder is 0 return 1
        return 0;
    }
}
