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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy;

        while (true) {

            // Find the kth node
            ListNode kth = prevGroupTail;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // Not enough nodes left
            if (kth == null)
                break;

            ListNode groupStart = prevGroupTail.next;
            ListNode nextGroup = kth.next;

            // Cut the list
            kth.next = null;

            // Reverse current group
            ListNode prev = null;
            ListNode curr = groupStart;

            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Reconnect
            prevGroupTail.next = prev;
            groupStart.next = nextGroup;

            // Prepare for next iteration
            prevGroupTail = groupStart;
        }

        return dummy.next;
    }
}
