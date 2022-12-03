/*Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.


Input Format

The only argument given is string A.
Output Format

Return the length of the longest consecutive 1’s that can be achieved.
Constraints

1 <= length of string <= 1000000
A contains only characters 0 and 1.
For Example

Input 1:
    A = "111000"
Output 1:
    3

Input 2:
    A = "111011101"
Output 2:
    7 */

package ArrayInterviewQuestions;

public class LongestConsecutiveOnes {
    public static void main(String[] args) {
        String str = "111011101";
        int longestSubStr = solve(str);
        System.out.println("length of longest substring of 1s can be formed of size: " + longestSubStr);
    }

    /**
     * @param A Binary String
     * @return integer: denoting length of longest Substring of ones with one swap of 0
     */
    public static int solve(String A) {
        int strLen = A.length();
        int maxCons = 0;
        //for counting number of 1s in a String TC O(N)
        int total1s = 0;
        for(int i=0;i<strLen;i++){
            if(A.charAt(i)=='1')total1s++;
        }
        //if string on 1s OR string of 0s TC O(1)
        if(total1s==A.length() || total1s==0) return total1s;

        // for each 0 in the integer... TC O(N)
        for(int i=0;i<strLen;i++){
            if(A.charAt(i)=='0'){
                int right1s = 0;
                int left1s = 0;
                //iterate right
                if(i!=strLen-1){ // i is not the last element
                    for(int r = i+1; r<strLen;r++){
                        if(A.charAt(r)=='0') break;
                        right1s++;
                    }
                }
                //iterate left
                if(i!=0){ // i is not the last element
                    for(int l = i-1; l>=0;l--){
                        if(A.charAt(l)=='0') break;
                        left1s++;
                    }
                }

                // checking availability of 1 for swaping 0
                if(right1s==total1s || left1s==total1s 
                || right1s + left1s==total1s){
                    return total1s;
                }
                
                //comparing with maxCons
                maxCons = Math.max(maxCons,(right1s+left1s+1));
            }
        }
        return maxCons;
    }
}
