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
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int[] dfs(TreeNode node){
        if(node==null) return new int[]{0,0};
        int[] left=dfs(node.left);
        int[] right=dfs(node.right);
        int[] curr = new int[]{left[0]+right[0]+node.val,left[1]+right[1]+1};
        if(curr[0]/curr[1]==node.val) ans++;
        return curr;
    }
}