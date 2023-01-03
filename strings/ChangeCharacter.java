/*Problem Description
You are given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.



Problem Constraints
1 <= N <= 100000

0 <= B < N



Input Format
The first argument is a string A.

The second argument is an integer B.



Output Format
Return an integer denoting the minimum number of distinct characters in the string.



Example Input
A = "abcabbccd"
B = 3



Example Output
2



Example Explanation
We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.

 */
package strings;

import java.util.Arrays;

public class ChangeCharacter {
    public static void main(String[] args) {
        String A = "abcabbccd";
        int B = 3;
        System.out.println(solve(A, B));
    }
    public static int solve(String A, int B) {
        char[] arr = A.toCharArray();
        if(arr.length == 1 && B==1){
            return 1;
        }
        int[] count = new int[26];
        for(int i = 0; i <arr.length; i++){
            int idx = arr[i] - 'a';
            count[idx] = count[idx] + 1;
        }
        int filledidx= 0;
        for(int i = 0 ; i < count.length; i++){
            if(count[i] != 0){
                filledidx++;
            }
        }
        Arrays.sort(count);
        for(int j = 0 ; j < count.length; j++){
            if(count[j] > 0 && count[j] <= B){
                filledidx--;
                B = B-count[j];
            }
            else if(count[j] == 0){
                continue;
            }
            else{
                break;
            }
        }
        return filledidx;
    }
}
