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
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;
    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        push(st,root);
    }
    
    public int next() {
        TreeNode top = st.pop();
        if(!reverse){
            if(top.right != null){
                push(st,top.right);
            }
        }
        else{
            if(top.left != null){
                push(st,top.left);
            }
        }
        return top.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void push(Stack<TreeNode> st , TreeNode root){
        if(root == null) return;
        if(!reverse){
            while(root != null){
                st.add(root);
                root = root.left;
            }
        }
        else{
            while(root != null){
                st.add(root);
                root = root.right;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root , false);
        BSTIterator r = new BSTIterator(root , true);
        int i = l.next();//This is for next();
        int j = r.next();//This is for before();
        while(i < j){
            if(i + j > k){
                j = r.next();
            }
            else if( i+ j < k){
                i = l.next();
            }
            else{
                return true;
            }
        }
        return false;
    }
}