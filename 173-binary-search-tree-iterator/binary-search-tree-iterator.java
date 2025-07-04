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
    public BSTIterator(TreeNode root) {
        push(st,root);
    }
    
    public int next() {
        TreeNode top = st.pop();
        if(top.right != null){
            push(st,top.right);
        }
        return top.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void push(Stack<TreeNode> st , TreeNode root){
        if(root == null) return;

        while(root != null){
            st.add(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */