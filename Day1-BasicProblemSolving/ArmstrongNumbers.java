/*Problem Description
You are given an integer A. You need to print all the Armstrong Numbers between 1 to A.

If sum of cubes of each digit of the number is equal to the number itself, then the number is called an Armstrong number.

For example, 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 ).



Problem Constraints
1 <= N <= 500



Input Format
First and only argument is an integer A.



Output Format
Return an integer array of all the Armstrong numbers in range [1,A].



Example Input
Input 1:

 5
Input 2:

 200


Example Output
Output 1:

1
Output 2:

[1, 153]


Example Explanation
Explanation 1:

1 is an armstrong number.
Explanation 2:

1 and 153 are armstrong number under 200. */

import java.util.ArrayList;
import java.util.Scanner;

public class ArmstrongNumbers {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in); //Declaring Scanner object
        System.out.println("Input a number\n"); 
        int n = Scan.nextInt();    //getting input from console
        Scan.close();   //closing scanner
        ArrayList<Integer> numbers= solve(n); // declaring ArrayList to store output
        System.out.println("All the Armstrong numbers from 1 to "+n+" are\n");
        for (int num : numbers) {   // printing all the armstrong numbers
            System.out.print(num +" ");
        }
    }
    public static ArrayList<Integer> solve(int A) {
        ArrayList<Integer> armstrongNumber = new ArrayList<Integer>();
        for(int i =1;i<=A;i++){
            String number = String.valueOf(i);
            String[] digits = number.split("");
            int sum = 0;
            for(String n : digits){
                int num = Integer.parseInt(n);
                sum+= num*num*num;
                if(sum>A) break;
            }
            if(sum==i) armstrongNumber.add(i);

        }
        return armstrongNumber;
    }
}
