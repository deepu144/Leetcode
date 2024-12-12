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
    TreeNode first=null,second=null,pre=null;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int t=first.val;
        first.val=second.val;
        second.val=t;
    }
    public void inOrder(TreeNode node){
        if(node==null) return;
        inOrder(node.left);
        if(pre!=null && pre.val>node.val){
            if(first==null) first=pre;
            second=node;
        }
        pre=node;
        inOrder(node.right);
    }
}