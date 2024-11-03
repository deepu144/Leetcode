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
    final int MOD=(int)(1e9+7);
    long max=-1;
    public int maxProduct(TreeNode root) {
        long tot=treeSum(root);
        dfs(root,tot);
        return (int)(max%MOD);
    }
    public long treeSum(TreeNode node){
        if(node==null) return 0L;
        return (long)node.val+treeSum(node.left)+treeSum(node.right);
    }
    public long dfs(TreeNode node,long tot){
        if(node==null) return 0;
        long sum=(long)node.val+dfs(node.left,tot)+dfs(node.right,tot);
        max=Math.max(max,(tot-sum)*sum);
        return sum;
    }
}