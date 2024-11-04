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
    final String ARR=\->\;
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        path(root,ans,new ArrayList<>());
        return ans;
    }
    public void path(TreeNode node,List<String> ans,List<Integer> li){
        if(node==null) return;
        if(node.left==null && node.right==null){
            li.add(node.val);
            StringBuilder sb=new StringBuilder();
            for(int i : li){
                sb.append(i);
                sb.append(ARR);
            }
            if(sb.length()>2){
                sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(sb.length()-1);
            }
            ans.add(sb.toString());
            li.removeLast();
            return;
        }
        li.add(node.val);
        path(node.left,ans,li);
        li.removeLast();
        li.add(node.val);
        path(node.right,ans,li);
        li.removeLast();
    }
}