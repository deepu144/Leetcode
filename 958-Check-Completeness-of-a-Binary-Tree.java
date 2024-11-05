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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean f=false,t=false;
        while(!q.isEmpty()){
            TreeNode p=q.poll();
            if(p.left==null && p.right==null) t=true;
            if(f) if(p.left!=null || p.right!=null) return false;
            if(p.left==null && p.right!=null) return false;
            if(p.left!=null && p.right!=null){
                if(t) return false;
                q.offer(p.left);
                q.offer(p.right);
            }else if(p.left!=null && p.right==null){
                if(t) return false;
                f=true;
                q.offer(p.left);
            }
        }
        return true;
    }
}