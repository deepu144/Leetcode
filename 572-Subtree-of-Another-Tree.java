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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return preOrder(root,subRoot);
    }
    public boolean preOrder(TreeNode node,TreeNode root){
        if(node==null) return false;
        if(node.val==root.val){
            if(dfs(node,root)) return true;
        }
        return preOrder(node.left,root)||preOrder(node.right,root);
    }

    public boolean dfs(TreeNode r , TreeNode l){
        if(r!=null && l!=null){
            if(r.val!=l.val) return false;
            if(!dfs(r.right,l.right)) return false;
            if(!dfs(r.left,l.left)) return false;
            return true;
        }else if(r==null && l==null) return true;
        return false;
    }
}