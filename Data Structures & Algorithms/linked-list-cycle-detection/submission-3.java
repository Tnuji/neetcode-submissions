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
        ListNode left = head;
        ListNode right = head;

        while(left != null && right != null)
        {
            if(left.next == null || right.next == null) return false;
            right = right.next.next;
            left = left.next;
            if(left == right) return true;
        }
        return false;
    }
}
