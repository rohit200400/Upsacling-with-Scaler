/*Problem Description
Given two binary strings A and B. Return their sum (also a binary string).


Problem Constraints
1 <= length of A <= 105

1 <= length of B <= 105

A and B are binary strings



Input Format
The two argument A and B are binary strings.



Output Format
Return a binary string denoting the sum of A and B



Example Input
Input 1:
A = "100"
B = "11"
Input 2:
A = "110"
B = "10"


Example Output
Output 1:
"111"
Output 2:
"1000"


Example Explanation
For Input 1:
The sum of 100 and 11 is 111.
For Input 2:
 
The sum of 110 and 10 is 1000. */
package strings;

public class AddBinaryStrings {
    public static void main(String[] args) {
        String A = "100",B = "11";
        System.out.println("Sum of binary number "+A+" "+B+" is "+addBinary(A, B));
    }
    public static String addBinary(String a, String b) {
            if(a.charAt(0) == '0' && b.charAt(0) == '0'){
                 return "0";
            }
            // Initialize result
            StringBuilder result = new StringBuilder(""); 
              
            // Initialize digit sum
            int s = 0;         
      
            // Traverse both strings starting 
            // from last characters
            int i = a.length() - 1, j = b.length() - 1;
            while (i >= 0 || j >= 0 || s == 1)
            {
                  
                // Comput sum of last 
                // digits and carry
                s += ((i >= 0)? a.charAt(i) - '0': 0);
                s += ((j >= 0)? b.charAt(j) - '0': 0);
      
                // If current digit sum is 
                // 1 or 3, add 1 to result
                result.append((char)(s % 2 + '0'));
      
                // Compute carry
                s /= 2;
      
                // Move to next digits
                i--; j--;
            }
            
              // Remove leading zeros, if any
              int start = result.length()-1;
              
            while(start >=0 && result.charAt(start) == '0') {
                start--;
            }
              
            if(start != result.length()-1) {
                result.delete(start+1,result.length());
            }
              
            return result.reverse().toString();
    }
}
