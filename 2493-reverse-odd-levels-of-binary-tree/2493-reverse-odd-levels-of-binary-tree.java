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
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left,root.right,1);
        return root;
    }
    public void dfs(TreeNode left,TreeNode right,int depth){
        if(left==null) return;
        if((depth & 1)==1){
            int t=left.val;
            left.val=right.val;
            right.val=t;
        }
        dfs(left.left,right.right,depth+1);
        dfs(left.right,right.left,depth+1);
    }
}