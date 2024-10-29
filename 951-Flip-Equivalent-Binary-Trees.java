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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null) return true;
        if(root1==null||root2==null) return false;
        PriorityQueue<TreeNode> q1=new PriorityQueue<>((a,b)->a.val-b.val);
        PriorityQueue<TreeNode> q2=new PriorityQueue<>((a,b)->a.val-b.val);
        q1.offer(root1);
        q2.offer(root2);
        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode p1=q1.poll();
            TreeNode p2=q2.poll();
            if(p1.val!=p2.val) return false;
            List<Integer> l1=new ArrayList<>();
            List<Integer> l2=new ArrayList<>();
            if(p1.left!=null){
                l1.add(p1.left.val);
                q1.offer(p1.left);
            }
            if(p1.right!=null){
                if(l1.size()>0){
                    if(l1.get(0)<p1.right.val) l1.add(p1.right.val);
                    else l1.addFirst(p1.right.val);
                }else l1.add(p1.right.val);
                q1.offer(p1.right);
            }
            if(p2.left!=null){
                l2.add(p2.left.val);
                q2.offer(p2.left);
            }
            if(p2.right!=null){
                if(l2.size()!=0){
                    if(l2.get(0)<p2.right.val) l2.add(p2.right.val);
                    else l2.addFirst(p2.right.val);
                }else l2.add(p2.right.val);
                q2.offer(p2.right);
            }

            if(!l1.equals(l2)) return false;
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}