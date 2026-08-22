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
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode prevEnd = dummy;
        while(true)
        {
            ListNode kth = prevEnd;

            for(int i = 0; i < k && kth != null; ++i)
            {
                kth = kth.next;
            }

            if(kth == null)break;

            ListNode groupStart = prevEnd.next;
            ListNode nextGroup = kth.next;

            kth.next = null;

            prevEnd.next = reverse(groupStart);
            groupStart.next = nextGroup;
            prevEnd = groupStart;



        }
      return dummy.next;   

    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
