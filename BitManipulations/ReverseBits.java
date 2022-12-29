/*Problem Description
Reverse the bits of an 32 bit unsigned integer A.



Problem Constraints
0 <= A <= 232



Input Format
First and only argument of input contains an integer A.



Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.



Example Input
Input 1:

 0
Input 2:

 3


Example Output
Output 1:

 0
Output 2:

 3221225472


Example Explanation
Explanation 1:

        00000000000000000000000000000000    
=>      00000000000000000000000000000000
Explanation 2:

        00000000000000000000000000000011    
=>      11000000000000000000000000000000 */
package BitManipulations;

public class ReverseBits {
    public static void main(String[] args) {
        long num = 1342177280;
        System.out.println("reversed bits produce this decimal number: " +reverse(num));
    }
    public static long reverse(long A) {
	    long rev = 0; // this is the output number
	    
	    for (int i = 0; i < 32; i++) { // iterating through each bit in the given number
	        // left shifting 1 bit
            rev <<= 1;
            // if ith bit in A is set then we are setting first bit in rev
	        if ((A & (1 << i)) != 0) rev |= 1;
	    }
	    return rev;
	}
}
