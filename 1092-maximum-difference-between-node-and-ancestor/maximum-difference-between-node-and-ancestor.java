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
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        return maxdiff(root, root, root);
    }

    public int maxdiff(TreeNode root , TreeNode max , TreeNode min){
        if(root == null) return max.val - min.val;
        
        if(root.val > max.val)max = root;
        else if(root.val < min.val) min = root;
        int left = maxdiff(root.left , max , min);
        int right = maxdiff(root.right , max , min);
        return Math.max(left , right);
    }
}