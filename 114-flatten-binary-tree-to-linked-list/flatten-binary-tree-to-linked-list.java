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
    public void flatten(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        preorder(al,root);
        TreeNode curr = root;
        for(int i =1;i<al.size();i++){
            curr.left = null;
            curr.right = new TreeNode(al.get(i));
            curr = curr.right;
        }
    }
    public void preorder(List<Integer> al , TreeNode root){
        if(root == null)return;

        al.add(root.val);
        preorder(al,root.left);
        preorder(al,root.right);
    }
}