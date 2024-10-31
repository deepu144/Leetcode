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
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return 0;
        return dfs(root,(int)(1e8),(int)(-1e8));
    }
    public int dfs(TreeNode node,int min,int max){
        if(node==null) return max-min;
        if(max<node.val) max=node.val;
        if(min>node.val) min=node.val;
        int right=dfs(node.right,min,max);
        int left=dfs(node.left,min,max);
        return Math.max(right,left);
    }
}