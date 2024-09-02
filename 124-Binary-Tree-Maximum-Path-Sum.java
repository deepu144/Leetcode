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
    int max=-1;
    public int maxPathSum(TreeNode root) {
        max=root.val;
        height(root);
        return max;
    }
    public int height(TreeNode node){
        if(node==null) return 0;
        int l=Math.max(0,height(node.left));
        int h=Math.max(0,height(node.right));
        max=Math.max(l+h+node.val,max);
        return Math.max(l,h)+node.val;
    }
    
}