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

        ListNode second = slow.next;
        slow.next = null;
        ListNode first = head;

        ListNode prev = null;
        while(second != null)
        {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        while(prev != null)
        {
            ListNode leftNext = first.next;
            ListNode rightNext = prev.next;

            first.next = prev;
            prev.next = leftNext;

            first = leftNext;
            prev = rightNext;
        }
    }
}