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
    public int minimumOperations(TreeNode root) {
        List<List<Integer>> tree=new ArrayList<>();
        dfs(root,tree,0);
        int min=0;
        for(List<Integer> level : tree) min+=findMinOperation(level);;
        return min;
    }
    public int findMinOperation(List<Integer> level){
        int count=0,size=level.size();
        int[] arr=new int[size];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<size;i++){
            arr[i]=level.get(i);
            map.put(arr[i],i);
        }
        Collections.sort(level);
        int i=0;
        while(i<size){
            if(arr[i]!=level.get(i)){
                int ind=map.get(level.get(i));
                int temp=arr[i];
                arr[i]=arr[ind];
                arr[ind]=temp;
                count++;
                map.put(temp,ind);
            }
            i++;
        }
        return count;
    }
    public void dfs(TreeNode node,List<List<Integer>> tree,int level){
        if(node==null) return;
        if(level==tree.size()) tree.add(new ArrayList<>());
        dfs(node.left,tree,level+1);
        tree.get(level).add(node.val);
        dfs(node.right,tree,level+1);
    }
}