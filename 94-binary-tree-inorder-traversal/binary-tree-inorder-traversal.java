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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     ArrayList<Integer> Al = new ArrayList<>();
    //     f(root, Al);
    //     return Al;
    // }
    // public void f(TreeNode root, List<Integer> Al){
    //     if(root == null) return;

    //     f(root.left , Al);
    //     Al.add(root.val);
    //     f(root.right , Al);
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> Al = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                Al.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    Al.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return Al;
    }
}