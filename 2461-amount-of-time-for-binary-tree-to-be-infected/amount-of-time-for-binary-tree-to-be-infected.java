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
    public void findparent(TreeNode root , HashMap<TreeNode,TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parent.put(curr.left , curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
    public TreeNode find_node(TreeNode temp, int start){
        if(temp == null)return null;
        if(temp.val == start){
            return temp;
        }
        TreeNode left = find_node(temp.left, start);
        if(left != null)return left;
        TreeNode right = find_node(temp.right, start);
        return right;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        findparent(root , parent);
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        TreeNode node = find_node(root,start);
        
        q.offer(node);
        visited.put(node,true);
        int min_time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent.get(curr) != null && visited.get(parent.get(curr)) == null){
                    q.offer(parent.get(curr));
                    visited.put(parent.get(curr),true);
                }
            }
            min_time++;
        }
        return min_time - 1;
    }
}