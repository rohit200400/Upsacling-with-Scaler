/*Given an array of integers A and an integer B.

Find the total number of subarrays having sum equals to B.


Input Format

The first argument given is the integer array A.
The second argument given is integer B.
Output Format

Return the total number of subarrays having sum equals to B.
Constraints

1 <= length of the array <= 50000
-1000 <= A[i] <= 1000 
For Example

Input 1:
    A = [1, 0, 1]
    B = 1
Output 1:
    4
    Explanation 1:
        [1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.

Input 2:
    A = [0, 0, 0]
    B = 0
Output 2:
    6 */
package Hashing;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] A = {5, 10, 3, 2, 50, 80};
        int K = 5;
        System.out.println("Total "+solve(A, K)+" subarrays whose sum is "+K);
    }
    public static int solve(int[] A, int B) {
        int n = A.length;
        int sum = 0;
        int cnt = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            sum += A[i];
            if(sum == B){
                cnt++;
            }
            if(hm.containsKey(sum - B)){
                cnt += hm.get(sum - B);
            }
            if(hm.containsKey(sum)){
                hm.put(sum, hm.get(sum)+1);
            } 
            else {
                hm.put(sum, 1);
            }
        }
        return cnt;
    }
}
