/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pli=new ArrayList<>();
        findPath(root,p.val,pli);
        List<TreeNode> qli=new ArrayList<>();
        findPath(root,q.val,qli);
        TreeNode ans=null;
        int i=0,m=pli.size(),n=qli.size();
        while(m>i || n>i){
            if(m>i && n>i){
                if(pli.get(i).val==qli.get(i).val) ans=pli.get(i);
                else break;
            }else break;
            i++;
        }
        return ans;
    }
    public boolean findPath(TreeNode node,int key,List<TreeNode> li){
        if(node==null) return false;
        li.add(node);
        boolean l = findPath(node.left,key,li);
        if(node.val==key) return true;
        boolean r = findPath(node.right,key,li);
        if(l || r) return true;
        li.remove(li.size()-1);
        return false;
    }
}