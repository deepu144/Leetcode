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
    int fre;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> li=new ArrayList<>();
        fre=0;
        dfs(root,map);
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            if(m.getValue()==fre) li.add(m.getKey());
        }
        return li.stream().mapToInt(i->i).toArray();
    }
    public int dfs(TreeNode node,Map<Integer,Integer> map){
        if(node==null) return 0;
        int sum=node.val+dfs(node.left,map)+dfs(node.right,map);
        map.put(sum,map.getOrDefault(sum,0)+1);
        fre=Math.max(fre,map.get(sum));
        return sum;
    }
}