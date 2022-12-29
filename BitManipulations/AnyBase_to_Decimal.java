/*Problem Description
You are given a number A. You are also given a base B. A is a number on base B.
You are required to convert the number A into its corresponding value in decimal number system.


Problem Constraints
0 <= A <= 109
2 <= B <= 9


Input Format
First argument A is an integer.
Second argument B is an integer.


Output Format
Return an integer.


Example Input
Input 1:
A = 1010
B = 2
Input 2:
A = 22 
B = 3


Example Output
Output 1:
10
Output 2:
8
 */

package BitManipulations;

public class AnyBase_to_Decimal {
    public static void main(String[] args) {
        int number = 101010;
        int base = 2;
        int decimalNumber = solve(number, base);
        System.out.println("decimal number: "+decimalNumber);

    }

    public static int solve(int A, int B) {
        int decimal = 0 ; 
        int power = 0 ; 
        while(A > 0 ){
            int reminder = A%10 ; 
            decimal += reminder*Math.pow(B,power);
            power++;
            A = A/10;
        }
        return decimal;
    }
}
