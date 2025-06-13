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
        List<Integer> res = new ArrayList<>();
        f(res , root , 0);
        return res;
    }
    public void f(List<Integer> al , TreeNode root , int level){
        if(root == null) return;

        if(al.size() == level) al.add(root.val);

        f(al, root.right , level + 1);
        f(al , root.left , level + 1);
    }
}