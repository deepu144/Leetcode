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
    int count=0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return count;
    }
    public int dfs(TreeNode node){
        if(node==null) return 0;
        int left=dfs(node.left);
        int right=dfs(node.right);
        int coinsNeed=left+right+node.val-1;
        count+=(Math.abs(left)+Math.abs(right));
        return coinsNeed;
    }
}