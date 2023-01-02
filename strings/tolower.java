/*Problem Description
You are given a function to_lower() which takes a character array A as an argument.

Convert each character of A into lowercase characters if it exists. If the lowercase of a character does not exist, it remains unmodified.
The uppercase letters from A to Z are converted to lowercase letters from a to z respectively.

Return the lowercase version of the given character array.



Problem Constraints
1 <= |A| <= 105



Input Format
The only argument is a character array A.



Output Format
Return the lowercase version of the given character array.



Example Input
Input 1:

 A = ['S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
Input 2:

 A = ['S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0']


Example Output
Output 1:

 ['s', 'c', 'a', 'l', 'e', 'r', 'a', 'c', 'a', 'd', 'e', 'm', 'y']
Output 2:

 ['s', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']


Example Explanation
Explanation 1:

 All the characters in the returned array are in lowercase alphabets.*/
package strings;

public class tolower {
    public static void main(String[] args) {
        char[] A = {'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'};
        char[] out = to_lower(A);
        for (char c : out) {
            System.out.print(c+" ");
        }
    }
    public static char[] to_lower(char[] A) {
        //capital ASCII 65-90
        // int asciiVal = char
        for(int i =0; i<A.length;i++){
            int asciiVal = A[i];
            if(asciiVal>64 && asciiVal<91){
                //char character = (asciiVal+32);
                A[i]= (char)(asciiVal+32);
            }
        }
        return A;
    }
}
