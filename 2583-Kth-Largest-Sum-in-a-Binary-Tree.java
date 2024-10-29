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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode p=q.poll();
                sum+=p.val;
                if(p.left!=null) q.offer(p.left);
                if(p.right!=null) q.offer(p.right);
            }
            if(pq.size()<k) pq.offer(sum);
            else if(pq.size()==k){
                if(pq.peek()<sum){
                    pq.poll();
                    pq.offer(sum);
                }
            }
        }
        if(pq.size()!=k || pq.isEmpty()) return -1;
        return pq.poll();
    }
}