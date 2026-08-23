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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        else{
            int left = getheight(root.left);
            int right = getheight(root.right);
            return Math.abs(right - left) <= 1 && isBalanced(root.right) && isBalanced(root.left);
        }
    }

    public int getheight(TreeNode root)
    {
        if(root == null) return 0;
        return 1 + Math.max(getheight(root.left), getheight(root.right));
    }
}
