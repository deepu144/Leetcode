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
    public int goodNodes(TreeNode root) {
        return dfs(root,(int)(-1e8));
    }
    public int dfs(TreeNode node,int pre){
        if(node==null) return 0;
        int count=0;
        if(pre<=node.val) count=1+dfs(node.left,node.val)+dfs(node.right,node.val);
        else count+=(dfs(node.left,pre)+dfs(node.right,pre));
        return count;
    }
}