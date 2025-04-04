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
    int maxHeight=0;
    TreeNode ans;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        height(root,0);
        return ans;
    }
    public int height(TreeNode node,int level){
        if(node==null){
            maxHeight=Math.max(maxHeight,level);
            return level;
        }
        int left=height(node.left,level+1);
        int right=height(node.right,level+1);
        if(left==maxHeight && left==right) ans=node;
        return Math.max(left,right);
    }
}