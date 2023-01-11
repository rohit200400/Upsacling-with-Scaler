/*Problem Description
Given an array A of N integers.

Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
Single argument which is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:

 A = [1, -1, -2, 2]
Input 2:

 A = [-1, 2, -1]


Example Output
Output 1:

3
Output 2:

1


Example Explanation
Explanation 1:

 The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
Explanation 2:

 The subarray with zero sum is [-1, 2, -1]. */
package Hashing;

import java.util.HashMap;

public class CountSubarrayZeroSum2 {
    public static void main(String[] args) {
        int[] A = {1, -1, -2, 2};
        System.out.println(solve(A));
    }
    public static int solve(int[] A) {
        int count = 0 ;
        Long prefixSum = 0l;
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0l,1l); // for edge case of 0s ex: 00 count will be 3
        for(int num : A){
            prefixSum += num;
            if(map.containsKey(prefixSum)){
                count += map.get(prefixSum);
                map.put(prefixSum,map.get(prefixSum)+1l);
            }
            else
                map.put(prefixSum,1l);
        }
        return (int)count % 1000000007;
    }
}
