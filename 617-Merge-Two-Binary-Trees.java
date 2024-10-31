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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1!=null && root2==null) return root1;
        if(root1==null && root2!=null) return root2;
        if(root1==null && root2==null) return null;
        Queue<TreeNode[]> q=new LinkedList<>();
        root1.val+=root2.val;
        q.offer(new TreeNode[]{root1,root2});
        while(!q.isEmpty()){
            TreeNode[] p=q.poll(); 
            if(p[0].left!=null){
                if(p[1].left!=null){
                    p[0].left.val+=p[1].left.val;
                    q.offer(new TreeNode[]{p[0].left,p[1].left});
                }
            }else{
                if(p[1].left!=null) p[0].left=p[1].left;
            }
            if(p[0].right!=null){
                if(p[1].right!=null){
                    p[0].right.val+=p[1].right.val;
                    q.offer(new TreeNode[]{p[0].right,p[1].right});
                }
            }else{
                if(p[1].right!=null) p[0].right=p[1].right;
            }
        }
        return root1;
    }
}