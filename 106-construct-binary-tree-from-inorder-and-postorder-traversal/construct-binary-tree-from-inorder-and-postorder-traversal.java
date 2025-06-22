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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< inorder.length ; i++){
            map.put(inorder[i] , i);
        }

        TreeNode root = construct(postorder , postorder.length - 1 , 0 , inorder , 0 , inorder.length -1 , map);
        return root;
    }

    public TreeNode construct(int[] postorder , int poststart , int postend , int[] inorder , int instart ,int inend , HashMap<Integer,Integer> mp){
        if(poststart < postend || instart > inend)return null;
        TreeNode node = new TreeNode(postorder[poststart]);
        int inRoot = mp.get(postorder[poststart]);
        int numright = inend - inRoot;
        node.right = construct(postorder , poststart - 1 , poststart - numright , inorder , inRoot + 1, inend , mp );
        node.left = construct(postorder , poststart - numright - 1, postend , inorder ,instart,inRoot - 1,mp );
        return node;
    }
}