import java.util.Scanner;

/*Problem Description
Given an Integer A. Return 1 if A is prime and return 0 if not.


Problem Constraints
1 <= A <= 1012


Input Format
The first argument is a single integer A.


Output Format
Return 1 if A is prime else return 0.


Example Input
Input 1:
A = 5
Input 2:

A = 10


Example Output
Output 1:
1
Output 2:

0


Example Explanation
Explanation 1:
5 is a prime number.
Explanation 2:

10 is not a prime number. */

public class IsPrime {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        System.out.println("Input a number\n");
        Long n = Scan.nextLong();
        Scan.close();
        String answer = (isPrime(n)==1)? "Number is Prime" : "Number is not Prime";
        System.out.println(answer);
    }
    public static int isPrime(Long A) {
        if(A==1) return 0;
        if(A==2 || A==3)return 1;
        int flag = 1;
        for(int i =2; A/i>=i;i++){
            if(A%i==0){
                flag=0;
                return flag;
            }
        }
        return flag;
    }
}
