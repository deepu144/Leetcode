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
    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }
    public int check(TreeNode node){
        if(node==null) return 0;
        int left = check(node.left);
        int right = check(node.right);
        if(left==-1 || right==-1) return -1;
        if(Math.abs(left-right)>1) return -1;
        return 1+Math.max(left,right);
    }
}