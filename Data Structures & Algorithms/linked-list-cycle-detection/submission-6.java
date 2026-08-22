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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode turtle = head;
        ListNode hare = head;

        while(turtle != null && hare != null)
        {
            if(hare.next == null) return false;
            hare = hare.next.next;
            turtle = turtle.next;
            if(turtle == hare) return true;
        }
        return false;
    }
}
