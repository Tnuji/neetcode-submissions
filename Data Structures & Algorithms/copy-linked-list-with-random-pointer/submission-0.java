/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        // Step 1: Create copies of every node
        Node curr = head;

        while (curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);

            curr = curr.next;
        }

        // Step 2: Connect next and random pointers
        curr = head;

        while (curr != null) {
            Node copy = map.get(curr);

            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
}