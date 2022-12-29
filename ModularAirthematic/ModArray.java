/* Problem Description
You are given a large number in the form of a array A of size N where each element denotes a digit of the number.
You are also given a number B. You have to find out the value of A % B and return it.



Problem Constraints
1 <= N <= 105
0 <= Ai <= 9
1 <= B <= 109


Input Format
The first argument is an integer array A.
The second argument is an integer B.


Output Format
Return a single integer denoting the value of A % B.


Example Input
Input 1:
A = [1, 4, 3]
B = 2
Input 2:

A = [4, 3, 5, 3, 5, 3, 2, 1]
B = 47


Example Output
Output 1:
1
Output 2:

20


Example Explanation
Explanation 1:
143 is an odd number so 143 % 2 = 1.
Explanation 2:

43535321 % 47 = 20*/
package ModularAirthematic;

public class ModArray {

    public static void main(String[] args) {
        int[] A = {4, 3, 5, 3, 5, 3, 2, 1};
        int B = 47;
        System.out.println("Taking mod of the number will give this as remainder "+solve(A, B));
    }

    public static int solve(int[] A, int B) {
        long t=1;
        long rem=0;
        for(int i=A.length-1;i>=0;i--){
            rem+=(((A[i]%B)*t)%B);
            t=(t*10)%B;
        }
        return (int)(rem%B);
    }
}
