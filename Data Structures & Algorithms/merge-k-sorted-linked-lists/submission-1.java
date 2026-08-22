/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode l : lists)
        {
            heap.add(l);
        }

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(!heap.isEmpty())
        {
            ListNode temp = heap.poll();
            curr.next = temp;
            curr = curr.next;
            temp = temp.next;
            if(temp == null) continue;
            heap.add(temp);
        }

        return dummy.next;
    }
}
