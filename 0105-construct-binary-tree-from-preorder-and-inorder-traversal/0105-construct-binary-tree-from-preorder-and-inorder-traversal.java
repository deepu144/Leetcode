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
    public TreeNode construct(int[] preorder,int pLow,int pHigh,int[] inorder,int iLow,int iHigh,HashMap<Integer,Integer> map){
        if(iLow>iHigh || pLow>pHigh) return null;
        TreeNode root=new TreeNode(preorder[pLow]);
        int inorderIndex=map.get(preorder[pLow]);
        int numsLeft=inorderIndex-iLow;
        root.left=construct(preorder,pLow+1,pLow+numsLeft,inorder,iLow,inorderIndex-1,map);
        root.right=construct(preorder,pLow+numsLeft+1,pHigh,inorder,inorderIndex+1,iHigh,map);
        return root;
    }
}