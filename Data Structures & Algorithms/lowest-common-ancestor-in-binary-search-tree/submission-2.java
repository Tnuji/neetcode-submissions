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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lc = root;

        while(lc != null)
        {
            if(lc.val == p.val || lc.val == q.val) return lc;
            else if(lc.val > p.val && lc.val > q.val) lc = lc.left;
            else if(lc.val < p.val && lc.val < q.val) lc = lc.right;
            else return lc;
        }
        return lc;
    }
}
