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
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode node,int bit){
        if(node==null) return 0;
        bit^=(1<<node.val);
        int count=0;
        if(node.left==null && node.right==null) if((bit&(bit-1))==0) count=1;
        count+=dfs(node.left,bit)+dfs(node.right,bit);
        return count;
    }
}