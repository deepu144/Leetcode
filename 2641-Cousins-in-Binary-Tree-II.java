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
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        dfs(root,0,li);
        Queue<TreeNode> q=new LinkedList<>();
        int lvl=0;
        TreeNode parent=null;
        q.offer(root);
        while(!q.isEmpty()){
            lvl++;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode p=q.poll();
                int sum=0;
                if(p.left!=null) sum+=p.left.val;
                if(p.right!=null) sum+=p.right.val;
                if(p.left==null && p.right==null) continue;
                int res=li.get(lvl)-sum;
                if(p.left!=null){
                    p.left.val=res;
                    q.offer(p.left);
                }
                if(p.right!=null){
                    p.right.val=res;
                    q.offer(p.right);
                }
            }
        }
        root.val=0;
        return root;
    }
    public void dfs(TreeNode node,int lvl,List<Integer> li){
        if(node==null) return;
        if(lvl==li.size()) li.add(0);
        li.set(lvl,li.get(lvl)+node.val);
        dfs(node.left,lvl+1,li);
        dfs(node.right,lvl+1,li);
    }
}