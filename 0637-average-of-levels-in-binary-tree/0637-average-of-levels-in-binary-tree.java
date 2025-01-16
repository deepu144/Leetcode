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
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> level=new ArrayList<>();
        dfs(root,level,0);
        List<Double> res=new ArrayList<>();
        for(List<Integer> li : level){
            double val=0;
            for(int i : li) val+=i;
            res.add(val/li.size());
        }
        return res;
    }
    public void dfs(TreeNode node,List<List<Integer>> level,int lvl){
        if(node==null) return;
        if(lvl==level.size()) level.add(new ArrayList<>());
        level.get(lvl).add(node.val);
        dfs(node.left,level,lvl+1);
        dfs(node.right,level,lvl+1);
    }
}