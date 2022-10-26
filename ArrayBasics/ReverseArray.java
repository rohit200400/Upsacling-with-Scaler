/*Problem Description
You are given a constant array A.

You are required to return another array which is the reversed form of the input array.



Problem Constraints
1 <= A.size() <= 10000

1 <= A[i] <= 10000



Input Format
First argument is a constant array A.



Output Format
Return an integer array.



Example Input
Input 1:

A = [1,2,3,2,1]
Input 2:

A = [1,1,10]


Example Output
Output 1:

 [1,2,3,2,1] 
Output 2:

 [10,1,1] 


Example Explanation
Explanation 1:

Reversed form of input array is same as original array
Explanation 2:

Clearly, Reverse of [1,1,10] is [10,1,1]
 */

package ArrayBasics;
import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArray {
    public static ArrayList<Integer> solve(final ArrayList<Integer> A) {
        ArrayList<Integer> reversedArray = new ArrayList<Integer>();
        for(int i=A.size()-1;i>=0;i--){
            reversedArray.add(A.get(i));
        }
        return reversedArray;
    }
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        ArrayList<Integer> output = solve(array);
        for (Integer integer : output) {
            System.out.print(integer + " ");
        }
    }
}
