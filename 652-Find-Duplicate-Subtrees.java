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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans=new ArrayList<>();
        dfs(root,new HashMap<>(),ans);
        return ans;
    }
    public String dfs(TreeNode node,Map<String,Integer> map,List<TreeNode> ans){
        if(node==null) return \#\;
        String serialize = node.val+\,\+dfs(node.left,map,ans)+\,\+dfs(node.right,map,ans);
        map.put(serialize,map.getOrDefault(serialize,0)+1);
        if(map.get(serialize)==2) ans.add(node);
        return serialize;
    }
}