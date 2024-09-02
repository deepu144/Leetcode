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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> ds= new TreeMap<>();
        inorder(root,ds,0,0);
        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> l : ds.entrySet()){
            List<Integer> temp = new ArrayList<>();
            for(Map.Entry<Integer,PriorityQueue<Integer>> ll : l.getValue().entrySet()){
                PriorityQueue<Integer> pq = ll.getValue();
                while(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
            ans.add(temp);
        }
        return ans;
    }
    public void inorder(TreeNode node,TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> ds,int row,int col){
        if(node==null) return;
        if(ds.containsKey(row)){
            TreeMap<Integer,PriorityQueue<Integer>> temp = ds.get(row);
            if(temp.containsKey(col)){
                temp.get(col).offer(node.val);
            }else{
                temp.put(col,new PriorityQueue<>(List.of(node.val)));
                ds.put(row,temp);
            }
        }else{
            TreeMap<Integer,PriorityQueue<Integer>> temp = new TreeMap<>();
            temp.put(col,new PriorityQueue<>(List.of(node.val)));
            ds.put(row,temp);
        }
        inorder(node.left,ds,row-1,col+1);
        inorder(node.right,ds,row+1,col+1);
    }
}