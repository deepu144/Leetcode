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
    public List<TreeNode> allPossibleFBT(int n) {
        if((n&1)==0) return new ArrayList<>();
        return helper(n,new HashMap<>());
    }

    public List<TreeNode> helper(int n,HashMap<Integer,List<TreeNode>> dp){
        List<TreeNode> li=new ArrayList<>();
        if(n==1){
            li.add(new TreeNode(0));
            return li;
        }
        if(dp.containsKey(n)) return dp.get(n);
        for(int i=1;i<n;i+=2){
            List<TreeNode> left=helper(i,dp);
            List<TreeNode> right=helper(n-i-1,dp);
            for(int j=0;j<left.size();j++){
                for(int k=0;k<right.size();k++){
                    TreeNode t=new TreeNode(0);
                    t.left=left.get(j);
                    t.right=right.get(k);
                    li.add(t);
                }
            }
        }
        dp.put(n,li);
        return li;
    }
}