/*Problem Description
You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array


Problem Constraints
1 <= N <= 100
1 <= A[i] <= 105


Input Format
First argument A is an array of integers.


Output Format
Return a 2D array of integers


Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [5, 2, 1, 4]


Example Output
Output 1:
[[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
Output 2:
[[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]


Example Explanation
For Input 1:
All the subarrays of the array are returned. There are a total of 6 subarrays.
For Input 2:
All the subarrays of the array are returned. There are a total of 10 subarrays. */

package Array_SubArray;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubarray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 4, 5, 1));
        ArrayList<ArrayList<Integer>> subArr = new ArrayList<ArrayList<Integer>>(solve(arr));
        for (ArrayList<Integer> array : subArr) {
            for (Integer element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> subarr = new ArrayList<ArrayList<Integer>>();
        for(int s = 0 ; s<A.size() ; s++){
            for(int e = s ; e<A.size(); e++){
                //int idx = 0;
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for(int i=s ; i<=e ; i++){
                    temp.add(A.get(i));
                }
                subarr.add(temp);
                //idx++ ; 
            }
        }
        return subarr;
    }
}
