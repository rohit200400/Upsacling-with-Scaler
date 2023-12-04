import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class TopKElements {
    public static void main(String[] args) {
        int n = 6;
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int k = 4;

        // Function call
        int[] v = kthLargest(k, arr, n);
        for (int it : v)
            System.out.print(it + " ");
    }
    static int[] kthLargest(int k, int arr[], int n)
    {
        int[] ans = new int[n];

        // Creating a min-heap using priority queue
        PriorityQueue<Integer> pq
                = new PriorityQueue<>();//((a, b) -> a - b);

        // Iterating through each element
        for (int i = 0; i < n; i++) {

            // If size of priority
            // queue is less than k
            if (pq.size() < k)
                pq.add(arr[i]);
            else {
                if (arr[i] > pq.peek()) {
                    pq.remove();
                    pq.add(arr[i]);
                }

            }

            // If size is less than k
            if (pq.size() < k)
                ans[i] = -1;
            else
                ans[i] = pq.peek();
        }

        return ans;
    }

}
