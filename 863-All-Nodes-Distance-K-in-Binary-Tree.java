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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        Set<TreeNode> visit = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        dfs(root,map);
        q.offer(target);
        visit.add(target);
        while(k-->0){
            int size=q.size();
            while(size-->0){
                TreeNode t = q.poll();
                if(t.left!=null && visit.add(t.left)) q.offer(t.left);
                if(t.right!=null && visit.add(t.right)) q.offer(t.right);            
                if(map.containsKey(t)){
                    if(map.get(t)!=null && visit.add(map.get(t))){
                        q.offer(map.get(t));
                    }
                }
            }
        }
        for(TreeNode t : q) ans.add(t.val);
        return ans;
    }
    public TreeNode dfs(TreeNode node,HashMap<TreeNode,TreeNode> map){
        if(node==null) return null;
        TreeNode l = dfs(node.left,map);
        TreeNode r = dfs(node.right,map);
        if(l!=null) map.put(l,node);
        if(r!=null) map.put(r,node);
        return node;
    }
}