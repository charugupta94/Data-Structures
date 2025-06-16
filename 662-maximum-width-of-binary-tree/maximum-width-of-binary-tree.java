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
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node , int level){
            this.node = node;
            this.level = level;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root ,0));
        int width =0;
        while(!q.isEmpty()){
            int n = q.size();
            int left = 0;
            int right = 0;
            for(int i=0;i<n;i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int level = p.level;
                if(i == 0) left = level;
                if(i == n-1) right = level;
                if(node.left != null){
                    q.offer(new Pair(node.left , 2*level));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right , 2*level + 1));
                }
            }
            width =Math.max (width , right - left + 1);
        }
        return width;
    }
}