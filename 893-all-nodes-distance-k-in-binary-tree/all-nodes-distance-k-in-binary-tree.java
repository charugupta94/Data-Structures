/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void findparent(TreeNode root, HashMap<TreeNode,TreeNode> parent){
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        findparent(root,parent); 
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target , true);
        int level =0;
        while(!q.isEmpty()){
            int size = q.size();
            if(level == k){
                break;
            }
            level++;
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
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            res.add(curr.val);
        }
        return res;
    }
}