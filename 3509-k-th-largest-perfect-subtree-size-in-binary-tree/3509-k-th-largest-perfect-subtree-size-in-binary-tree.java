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
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        dfs(root,k,pq);
        if(pq.isEmpty() || pq.size()!=k) return -1;
        return pq.peek();
    }
    public int dfs(TreeNode node,int k,PriorityQueue<Integer> pq){
        if(node==null) return 0;
        int left=dfs(node.left,k,pq);
        int right=dfs(node.right,k,pq);
        if(left==right){
            if(left==0 && (node.left!=null || node.right!=null)) return 0;
            int val=left+right+1;
            if(pq.size()==k && pq.peek()<val) pq.poll();
            if(pq.size()<k) pq.offer(val);
            return val;
        }
        return 0;
    }
}