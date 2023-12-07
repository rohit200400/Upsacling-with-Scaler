import java.util.PriorityQueue;

public class TopKElements {
    public static void main(String[] args) {
        TopKElements topKElements = new TopKElements();
        int n = 12;
        int arr[] = { 1, 12, 3, 4,65, 6,11, 21, 31, 14, 5, 6 };
        int k = 4;

        // Function call
        int[] v = topKElements.kthLargest(k, arr, n);
        for (int it : v)
            System.out.print(it + " ");
    }
    public int[] kthLargest(int k, int arr[], int n)
    {
        int[] ans = new int[n];

        // Creating a min-heap using priority queue
        PriorityQueue<Integer> pq
                = new PriorityQueue<>();

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

            this.printKLargestElements(pq);
        }

        return ans;
    }
    public void printKLargestElements(PriorityQueue<Integer> pq){
        PriorityQueue<Integer> copyPq;
        synchronized (TopKElements.this){
            copyPq = new PriorityQueue<>(pq);
        }
        System.out.println();
        while(!copyPq.isEmpty()){
            System.out.print(copyPq.poll() + " ");
        }
    }
}
