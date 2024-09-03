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
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.right,root.left);
    }
    public boolean dfs(TreeNode r , TreeNode l){
        if(r!=null && l!=null){
            if(r.val!=l.val) return false;
            if(!dfs(r.right,l.left)) return false;
            if(!dfs(r.left,l.right)) return false;
            return true;
        }else if(r==null && l==null) return true;
        return false;
    }
}