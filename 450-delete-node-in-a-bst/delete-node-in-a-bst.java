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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key)return helper(root);
        TreeNode temp = root;
        while(temp!= null){
            if(temp.val > key){
                if(temp.left != null && temp.left.val == key){
                    temp.left = helper(temp.left);
                    break;
                }
                else{
                    temp = temp.left;
                }
            }
            else {
                if(temp.right != null && temp.right.val == key){
                    temp.right = helper(temp.right);
                    break;
                }
                else{
                    temp = temp.right;
                }
            }
        }
        return root;
    }
    public TreeNode helper(TreeNode root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        TreeNode rightchild = root.right;
        TreeNode rightmostonleft = findrightmost(root.left);
        rightmostonleft.right = rightchild;

        return root.left;
    }
    public TreeNode findrightmost(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
}