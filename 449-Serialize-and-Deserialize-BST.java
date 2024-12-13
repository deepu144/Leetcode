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
        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        return sb.toString();
    }

    public void preOrder(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append(\.,\);
            return;
        }
        sb.append(node.val+\,\);
        preOrder(node.left,sb);
        preOrder(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] a = data.split(\,\);
        Deque<String> q = new ArrayDeque<>(Arrays.asList(a));
        return construct(q);
    }

     public TreeNode construct(Deque<String> q){
        String n = q.pop();
        if(n.charAt(0)=='.') return null;
        TreeNode node = new TreeNode(Integer.parseInt(n));
        node.left = construct(q);
        node.right = construct(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;