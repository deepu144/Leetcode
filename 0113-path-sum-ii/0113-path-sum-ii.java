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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        dfs(root,targetSum,new ArrayList<>(),ans);
        return ans;
    }
    public void dfs(TreeNode node,int sum,List<Integer> li,List<List<Integer>> ans){
        if(node.left==null && node.right==null){
            if(sum==node.val){
                li.add(node.val);
                ans.add(new ArrayList<>(li));
                li.removeLast();
            }
            return;
        }
        li.add(node.val);
        if(node.left!=null) dfs(node.left,sum-node.val,li,ans);
        if(node.right!=null) dfs(node.right,sum-node.val,li,ans);
        li.removeLast();
    }
}