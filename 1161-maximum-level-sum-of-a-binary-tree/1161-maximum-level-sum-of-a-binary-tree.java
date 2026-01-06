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
    public int maxLevelSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = (int)(-1e9), level = 0;
        dfs(root, 1, map);
        for(int key : map.keySet()){
            int value = map.get(key);
            if(max == value) level = Math.min(key,level);
            else if(max < value){
                max = value;
                level = key;
            }
        }
        return level;
    }
    public void dfs(TreeNode node, int lvl,Map<Integer,Integer> map){
        if(node == null) return;
        int sum = map.getOrDefault(lvl,0);
        map.put(lvl,sum+node.val);
        dfs(node.left,lvl+1,map);
        dfs(node.right,lvl+1,map);
    }
}