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

class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longest(root);
        return max;
    }

    public int longest(TreeNode root)
    {
        if(root == null) return 0;

        int left = longest(root.left);
        int right = longest(root.right);

        max = Math.max(max, right +  left);
        return Math.max(right, left) + 1;
    }
}
