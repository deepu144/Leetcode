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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null) return null;
        List<List<Integer>> tree=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean isOdd=false;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode p=q.poll();
                li.add(p.val);
                if(p.left!=null){
                    q.add(p.left);
                    q.add(p.right);
                }
            }
            if(isOdd) Collections.reverse(li);
            tree.add(li);
            isOdd=!isOdd;
        }
        TreeNode res=new TreeNode(tree.getFirst().getFirst());
        q.clear();
        q.add(res);
        int ind=1;
        while(!q.isEmpty()){
            int size=q.size();
            if(ind==tree.size()) break;
            List<Integer> li=tree.get(ind);
            int j=0;
            for(int i=0;i<size;i++){
                TreeNode t=q.poll();
                t.left=new TreeNode(li.get(j++));
                t.right=new TreeNode(li.get(j++));
                q.add(t.left);
                q.add(t.right);
            }
            ind++;
        }
        return res;
    }
}