/*Problem Description
Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).



Problem Constraints
1 <= N <= 6000



Input Format
First and only argument is a string A.



Output Format
Return a string denoting the longest palindromic substring of string A.



Example Input
A = "aaaabaaa"


Example Output
"aaabaaa"


Example Explanation
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa". */
package strings;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String A = "aarababaaia";
        System.out.println(longestPalindrome(A));
    }
    public static String longestPalindrome(String A) {
        if(A.length()==1){
            return A;
        }
        int start = 0 ;
        int end = 0;
        int maxlen = 0;
        int result=0;
        //for -ve length
        for(int mid = 0;mid<A.length()-1;mid++){
             int p1=mid, p2=mid;
             while(p1>=0&&p2<=A.length()-1){
             if(A.charAt(p1)==A.charAt(p2)){
                  p1--;
                  p2++;
                }
                else{
                    break;
                }
            }
            result = p2-p1-1;
             if(maxlen<result){
             maxlen=result;
             start= p1+1;
             end = p2 -1;  
            } 
        }
         //for +ve length
        for(int mid = 0;mid<A.length()-1;mid++){
             int p1=mid, p2=mid+1;
             while(p1>=0&&p2<=A.length()-1){
             if(A.charAt(p1)==A.charAt(p2)){
                  p1--;
                  p2++;
                }else{
                    break;
                }
            }
            result = p2-p1-1;
            if(maxlen<result){
             maxlen=result;
             start= p1+1;
             end = p2 -1;  
            } 
        }
        return A.substring(start,end+1);
    }
}
