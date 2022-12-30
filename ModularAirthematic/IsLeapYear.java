/*Problem Description
Given an integer A representing a year, Return 1 if it is a leap year else, return 0.

A year is a leap year if the following conditions are satisfied:

The year is multiple of 400.
or the year is multiple of 4 and not multiple of 100.

Problem Constraints
1 <= A <= 109



Input Format
First and only argument is an integer A



Output Format
Return 1 if it is a leap year else return 0



Example Input
Input 1

 A = 2020
Input 2:

 A = 1999


Example Output
Output 1

 1
Output 2:

 0


Example Explanation
Explanation 1

 2020 is a leap year.
Explanation 2:

 1999 is not a leap year.*/
package ModularAirthematic;

public class IsLeapYear {
    public static void main(String[] args) {
        int year = 2000;
        String outputMsg = solve(year)==1? "Year is leap year.":"Year is not a leap year.";
        System.out.println(outputMsg);
    }
    public static int solve(int A) {
        if(A%400==0) return 1;
        else if(A%4==0 && A%100!=0) return 1;
        return 0;
    }
}
