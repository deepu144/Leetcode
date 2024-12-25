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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            long max=Long.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode p=q.poll();
                max=Math.max(max,p.val);
                if(p.left!=null) q.add(p.left);
                if(p.right!=null) q.add(p.right);
            }
            res.add((int)max);
        }
        return res;
    }
}