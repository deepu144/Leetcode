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
    int min=(int)(1e8);
    Integer pre;
    public int getMinimumDifference(TreeNode root) {
        pre=null;
        dfs(root);
        return min;
    }
    public void dfs(TreeNode node){
        if(node==null) return;
        dfs(node.left);
        if(pre!=null) min=Math.min(min,Math.abs(node.val-pre));
        pre=node.val;
        dfs(node.right);
    }
}