/*Problem Description
There are A people standing in a circle. Person 1 kills their immediate clockwise neighbour and pass the knife to the next person standing in circle. This process continues till there is only 1 person remaining. Find the last person standing in the circle.


Problem Constraints
1 <= A <= 105


Input Format
First argument A is an integer.


Output Format
Return an integer.


Example Input
Input 1:
A = 4
Input 2:
A = 5


Example Output
Output 1:
1
Output 2:
3


Example Explanation
For Input 1:
Firstly, the person at position 2 is killed, then the person at position 4 is killed,
then the person at position 3 is killed. So the person at position 1 survives. 
For Input 2:
 
Firstly, the person at position 2 is killed, then the person at position 4 is killed, 
then the person at position 1 is killed. Finally, the person at position 5 is killed. 
So the person at position 3 survives. */
package ArrayInterviewQuestions;

public class JosephusProblem {
    public static void main(String[] args) {
        int totalPeople  = 6;
        int lastPerson = solve(totalPeople);
        System.out.println("If " + totalPeople + " number of people are standing forming a circle," +
                            "\nand first person eliminates next person and passes knife to 3rd and so on"+
                            "\nthen the last surviver will be person standing on position " + lastPerson );
    }

    public static int solve(int A) {
        //finding closest 2^n
        int closest2n = 0; //declaring n
        while(Math.pow(2,closest2n)<=A){
            if (Math.pow(2,closest2n+1) <= A) closest2n++;
            else{break;}//if 2^n > A
        }
        return 2*(A-(int)(Math.pow(2,closest2n))) +1;
    }
}
