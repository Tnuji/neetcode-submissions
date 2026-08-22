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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode right = slow.next;
        slow.next = null;
        slow = head;

        ListNode prev = null;
        
        while(right != null)
        {
            ListNode temp = right.next;
            right.next = prev;
            prev = right;
            right = temp;
        }

while (prev != null) {
    ListNode leftNext = slow.next;
    ListNode rightNext = prev.next;

    slow.next = prev;
    prev.next = leftNext;

    slow = leftNext;
    prev = rightNext;
}
    }
}
