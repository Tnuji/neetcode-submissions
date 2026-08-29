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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<>();
        if(root == null) return answer;

        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);

        while(!list.isEmpty())
        {
            int size = list.size();
            TreeNode temp = list.poll();
            while(size > 1){
                if(temp.left != null) list.offer(temp.left);
                if(temp.right != null) list.offer(temp.right);
                --size;
                temp = list.poll();
            }
            if(temp.left != null) list.offer(temp.left);
            if(temp.right != null) list.offer(temp.right);

            answer.add(temp.val);
        }

        return answer;
    }
}
