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
    final String E=\\;
    public List<List<String>> printTree(TreeNode root) {
        int row=height(root);
        int col=(1<<row)-1;
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<row;i++) res.add(new ArrayList<>(Collections.nCopies(col,E)));
        res.get(0).set((col-1)/2,root.val+E);
        set(root,0,(col-1)/2,res,row-1);
        return res;
    }
    public void set(TreeNode node,int row,int col,List<List<String>> res,int height){
        if(node==null) return;
        if(node.left!=null){
            int c=col-(1<<(height-row-1));
            res.get(row+1).set(c,node.left.val+E);
            set(node.left,row+1,c,res,height);
        }
        if(node.right!=null){
            int c=col+(1<<(height-row-1));
            res.get(row+1).set(c,node.right.val+E);
            set(node.right,row+1,c,res,height);
        }
    }
    public int height(TreeNode node){
        if(node==null) return 0;
        return Math.max(height(node.left),height(node.right))+1;
    }
}