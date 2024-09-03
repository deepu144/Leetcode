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
        return findAncestor(root,p.val,q.val);
    }
    public TreeNode findAncestor(TreeNode node,int p,int q){
        if(node==null) return null;
        TreeNode l = findAncestor(node.left,p,q);
        if(node.val==p) return node;
        if(node.val==q) return node;
        TreeNode r = findAncestor(node.right,p,q);
        if(l!=null && r!=null) return node;
        if(l==null && r!=null) return r;
        else if(l!=null && r==null) return l;
        return null;
    }
}