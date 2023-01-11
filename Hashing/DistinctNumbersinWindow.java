/*Problem Description
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Input Format
First argument is an integer array A
Second argument is an integer B.



Output Format
Return an integer array.



Example Input
Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:

 A = [1, 1, 2, 2]
 B = 1


Example Output
Output 1:

 [2, 3, 3, 2]
Output 2:

 [1, 1, 1, 1]


Example Explanation
Explanation 1:

 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:

 Window size is 1, so the output array is [1, 1, 1, 1]. */
package Hashing;

import java.util.HashMap;

public class DistinctNumbersinWindow {
    public static void main(String[] args) {
        int window = 3 ;
        int[]  array = {1, 2, 1, 3, 4, 3};
        System.out.print("distinct numbers in all windows of size "+window+" are ");
        int[] out = dNums(array, window);
        for (int i : out) {
            System.out.print(i+" ");
        }
    }
    public static int[] dNums(int[] A, int B) {
        int n=A.length;
        int[] sol=new int[n-B+1];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<B;i++)
        {  
            if(hm.containsKey(A[i]))
            hm.put(A[i],hm.get(A[i])+1);
            else        
            hm.put(A[i],1);
        }
            sol[0]=hm.size();
           
        for(int i=1;i<(n-B+1);i++){
            if(hm.containsKey(A[i-1])){
                if(hm.get(A[i-1])==1)
                hm.remove(A[i-1]);
                else
                hm.put(A[i-1],hm.get(A[i-1])-1);
            }          
           
            if(hm.containsKey(A[B+i-1])){
                hm.put(A[B+i-1],hm.get(A[B+i-1])+1);
            }
            else{
               hm.put(A[B+i-1],1);
            }
            sol[i]=hm.size();
           
        }
       
        return sol;
    }
}
