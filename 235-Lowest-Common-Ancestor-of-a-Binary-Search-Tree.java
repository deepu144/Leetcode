/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p,q);
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return root;
        if(root.val>p.val && root.val>q.val) return helper(root.left, p, q);
        else if(root.val<p.val && root.val<q.val) return helper(root.right, p, q);
        else return root;
    }
}