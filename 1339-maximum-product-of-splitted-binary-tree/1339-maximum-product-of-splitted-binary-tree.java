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
    long tot = 0, max = 0;
    final int MOD = (int)(1e9+7);
    public int maxProduct(TreeNode root) {
        this.tot = dfs(root);
        dfs1(root);
        return (int)(max%MOD);
    }
    public long dfs(TreeNode node){
        if(node == null) return 0L;
        return node.val + dfs(node.left) + dfs(node.right);
    }
    public int dfs1(TreeNode node){
        if(node == null) return 0;
        int val = node.val + dfs1(node.left) + dfs1(node.right);
        max = Math.max(max, (tot-val) * val);
        return val;
    }
}