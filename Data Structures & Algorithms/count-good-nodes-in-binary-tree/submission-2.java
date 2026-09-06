/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair{
    TreeNode node;
    int max_seen;

    public Pair(TreeNode node, int max)
    {
        this.node = node;
        this.max_seen = max;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        int goodnodes = 0;
        stack.push(new Pair(root, root.val));
        
        while(!stack.isEmpty())
        {
            Pair temp = stack.pop();
            int max = temp.max_seen;
            if(temp.node.val >= temp.max_seen)
            {
                ++goodnodes;
            }

            max = Math.max(temp.node.val, max);

            if(temp.node.left != null) stack.push(new Pair(temp.node.left, max));
            if(temp.node.right != null) stack.push(new Pair(temp.node.right, max));
        }
        return goodnodes;
    }
}