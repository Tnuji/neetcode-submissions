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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if(root.val == subRoot.val){
            if(same(root , subRoot)) return true;
        };
        
        return isSubtree(root.left , subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean same(TreeNode p, TreeNode q)
    {
        if(p == null || q == null) return p == null && q == null;

        if(p.val != q.val) return false;

        boolean equal = same(p.left , q.left);
        if(!equal) return false;
        equal = same(p.right, q.right);
        return equal;
    }
}
