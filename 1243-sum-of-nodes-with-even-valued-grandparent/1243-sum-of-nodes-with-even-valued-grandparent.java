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
    record Tuple(TreeNode node,TreeNode p,TreeNode gp){}
    public int sumEvenGrandparent(TreeNode root) {
        int sum=0;
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(root,null,null));
        while(!q.isEmpty()){
            Tuple p = q.poll();
            TreeNode node = p.node;
            TreeNode parent = p.p;
            TreeNode grandParent = p.gp;
            if(grandParent!=null && grandParent.val%2==0) sum+=node.val;
            if(node.left!=null) q.offer(new Tuple(node.left,node,parent));
            if(node.right!=null) q.offer(new Tuple(node.right,node,parent));
        }
        return sum;
    }
}