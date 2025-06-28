/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                res.append("n ");
                continue;
            }
            res.append(curr.val +" ");
            q.add(curr.left);
            q.add(curr.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);

        int i = 1;
        while(!q.isEmpty() && i < arr.length){
            TreeNode parent = q.poll();
            if(!arr[i].equals("n")){
                TreeNode lnode = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = lnode;
                q.add(lnode);
            }
            i++;
            if(i<arr.length && !arr[i].equals("n")){
                TreeNode rnode = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = rnode;
                q.add(rnode);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));