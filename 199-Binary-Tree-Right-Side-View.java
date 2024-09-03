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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        reversePreOrder(root,ans,0);
        return ans;
    }
    public void reversePreOrder(TreeNode node,List<Integer> ds,int level){
        if(node==null) return;
        if(level==ds.size()) ds.add(node.val);
        reversePreOrder(node.right,ds,level+1);
        reversePreOrder(node.left,ds,level+1);
    }
}