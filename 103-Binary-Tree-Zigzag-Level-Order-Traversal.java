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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        get(root,ans,0);
        for(int i=0;i<ans.size();i++){
            if(i%2==0) continue;
            Collections.reverse(ans.get(i));
        }
        return ans;
    }
    public void get(TreeNode node,List<List<Integer>> ans,int i){
        if(node==null) return;
        if(ans.size()==i) ans.add(new ArrayList<>());
        ans.get(i).add(node.val);
        get(node.left,ans,i+1);
        get(node.right,ans,i+1);
    }
}