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
    TreeNode res=null,temp=null;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return res;
    }
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        if(res==null){
            res=new TreeNode(root.val);
            temp=res;
        }
        else{
            temp.right=new TreeNode(root.val);
            temp=temp.right;
        }
        inOrder(root.right);
    }
}