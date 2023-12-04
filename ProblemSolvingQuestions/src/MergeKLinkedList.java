public class MergeKLinkedList {
    // Helper method to print the elements of a linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MergeKLinkedList merger = new MergeKLinkedList();

        // Test Case 1: Merge empty list
        ListNode[] emptyLists = {};
        ListNode result1 = merger.mergeKLists(emptyLists);
        printList(result1);

        // Test Case 2: Merge single list
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode[] singleList = {list1};
        ListNode result2 = merger.mergeKLists(singleList);
        printList(result2);

        // Test Case 3: Merge multiple lists
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(6)));
        ListNode list3 = new ListNode(2, new ListNode(7));
        ListNode[] multipleLists = {list1, list2, list3};
        ListNode result3 = merger.mergeKLists(multipleLists);
        printList(result3);

        // Test Case 4: Edge case with null input
        ListNode[] nullLists = null;
        ListNode result4 = merger.mergeKLists(nullLists);
        printList(result4);
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0) return null;
        return mergeSort(lists, 0, lists.length-1);
    }
    public ListNode mergeSort(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        if(end == start+1) return merge(lists[start],lists[end]);
        int mid = start + ((end - start)/2);
        return merge(mergeSort(lists,start, mid),  mergeSort(lists, mid+1, end));
    }
    public ListNode merge(ListNode l1, ListNode l2){
        //base case
        if(l1==null) return l2;
        if(l2==null) return l1;

        //case 1: value of l1 is less than value of l2
        if(l1.val<l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        //case 2: value of l2 is less than value of l1
        else{
            l2.next = merge(l1, l2.next);
            return l2;
        }

    }
}
