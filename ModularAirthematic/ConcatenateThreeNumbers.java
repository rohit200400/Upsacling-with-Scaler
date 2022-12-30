/*Problem Description
Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.

Return the minimum result obtained.



Problem Constraints
10 <= A, B, C <= 99



Input Format
The first argument of input contains an integer, A.

The second argument of input contains an integer, B.

The third argument of input contains an integer, C.



Output Format
Return an integer representing the answer.



Example Input
Input 1:

 A = 10
 B = 20
 C = 30
Input 2:

 A = 55
 B = 43
 C = 47 


Example Output
Output 1:

 102030 
Output 2:

 434755 


Example Explanation
Explanation 1:

 10 + 20 + 30 = 102030 
Explanation 2:

 43 + 47 + 55 = 434755  */
package ModularAirthematic;

public class ConcatenateThreeNumbers {
    public static void main(String[] args) {
        int A = 55;
        int B = 43;
        int C = 47;
        int ans = solve(A, B, C);
        System.out.println(ans);
    }
    public static int solve(int A, int B, int C) {
        String res ="";
        if(A<B)
        {
           if(A<C)
           {
               if(B<C)
               {
                   res = res+A+B+C;
               }
               else
               {
                   res = res+A+C+B;
               }
           }
           else
           {    
                res = res+C+A+B;

           }
        }
        else
        {
           if(B<C)
           {
               if(A<C)
               {
                    res = res+B+A+C;
               }
               else
               {
                   res = res+B+C+A;
               }
           }
           else
           {
               res = res+C+B+A;
           }
        }

        int result=Integer.parseInt(res);  

        return result;

    }   
}
