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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rev = reverse(head);
        ListNode start = rev;
        
        int counter = 1;
        
        if(counter == n)
        {
            rev = rev.next;
            return reverse(rev);
        }
        else{
            ++counter;
            while(rev != null)
            {
                if(counter == n){
                ListNode temp = rev.next;
                rev.next = temp.next;
                temp.next = null;
                break;
                }
                ++counter;
                rev = rev.next;
            }
            return reverse(start);
        }
    }
    public ListNode reverse(ListNode head){
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
