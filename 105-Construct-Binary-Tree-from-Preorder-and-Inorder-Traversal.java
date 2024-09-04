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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++) map.put(inorder[i],i);
        return construct(preorder,0,n-1,inorder,0,n-1,map);
    }
    public TreeNode construct(int[] p,int sl,int sh,int[] i,int il,int ih,HashMap<Integer,Integer> map){
        if(sl>sh || il>ih) return null;
        TreeNode node = new TreeNode(p[sl]);
        int pivot = map.get(node.val)-il;
        node.left = construct(p,sl+1,sl+pivot,i,il,pivot+il-1,map);
        node.right = construct(p,sl+pivot+1,sh,i,pivot+il+1,ih,map);
        return node;
    }
}