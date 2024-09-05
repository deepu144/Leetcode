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
        if(root==null) return \\;
        Deque<TreeNode> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        sb.append(root.val+\,\);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode t = q.pop();
                if(t.left==null) sb.append(\.,\);
                else{
                    q.offer(t.left);
                    sb.append(t.left.val+\,\);
                } 
                if(t.right==null) sb.append(\.,\);
                else{
                    q.offer(t.right);
                    sb.append(t.right.val+\,\);
                } 
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] a = data.split(\,\);
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(a[0]));
        q.offer(root);
        int i=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode t = q.pop();
                if(a[i].charAt(0)=='.') t.left=null;
                else{
                    t.left=new TreeNode(Integer.parseInt(a[i]));
                    q.offer(t.left);
                } 
                i++;
                if(a[i].charAt(0)=='.') t.right=null;
                else{
                    t.right=new TreeNode(Integer.parseInt(a[i]));
                    q.offer(t.right);
                } 
                i++;
            }
        }
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));