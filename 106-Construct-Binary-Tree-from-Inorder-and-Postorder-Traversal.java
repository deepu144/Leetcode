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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++) map.put(inorder[i],i);
        return build(inorder,postorder,0,n-1,0,n-1,map);
    }
    public TreeNode build(int[] i,int[] p,int il,int ih,int pl,int ph,HashMap<Integer,Integer> map){
        if(il>ih || pl>ph) return null;
        TreeNode node = new TreeNode(p[ph]);
        int ind = map.get(node.val);
        int size = ind-il;
        node.left = build(i, p, il, ind - 1, pl, pl + size - 1, map);
        node.right = build(i,p,ind+1,ih,pl+size,ph-1,map);
        return node;
    }
}