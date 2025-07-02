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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i =0;i<n;i++){
            mp.put(inorder[i],i);
        }
        TreeNode root = constructTree(preorder, 0, n-1, inorder , 0 , n-1, mp);
        return root;
    }
    public TreeNode constructTree(int[] preorder, int prestart , int preend, int[] inorder, int instart , int inend, HashMap<Integer, Integer> mp){
        if(prestart > preend || instart > inend) return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int inRoot = mp.get(preorder[prestart]);
        int numleft = inRoot - instart;

        root.left = constructTree(preorder , prestart + 1 , prestart + numleft , inorder ,  instart , inRoot - 1 , mp);
        root.right = constructTree(preorder, prestart + numleft + 1 , preend, inorder , inRoot + 1 , inend , mp); 
        return root;
    }
}