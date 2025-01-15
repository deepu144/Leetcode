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
    int tot=0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return tot;
    }
    public void dfs(TreeNode node,int num){
        if(node==null) return;
        if(node.left==null && node.right==null){
            num+=node.val;
            tot+=num;
            return;
        }
        dfs(node.left,(num+node.val)*10);
        dfs(node.right,(num+node.val)*10);
    }
}