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
    public TreeNode bstFromPreorder(int[] arr) {
        TreeNode root = null;
        for(int n : arr){
            if(root==null) root=new TreeNode(n);
            else root = insert(root,n);
        }
        return root;
    }
    public TreeNode insert(TreeNode node,int val){
        if(node==null) return new TreeNode(val);
        if(val<node.val) node.left = insert(node.left,val);
        else node.right = insert(node.right,val);
        return node;
    }
}