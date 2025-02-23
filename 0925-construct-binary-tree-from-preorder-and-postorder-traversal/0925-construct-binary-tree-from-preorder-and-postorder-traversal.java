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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n=preorder.length;
        int[] postMap=new int[n+1];
        int[] preMap=new int[n+1];
        for(int i=0;i<n;i++) postMap[postorder[i]]=i;
        for(int i=0;i<n;i++) preMap[preorder[i]]=i;
        return constructTree(preorder,postorder,preMap,postMap,0,n-1,0,n-1);
    }
    public TreeNode constructTree(int[] preorder,int[] postorder,int[] preMap,int[] postMap,int preStart,int preEnd,int postStart,int postEnd){
        TreeNode node=new TreeNode(preorder[preStart]);
        int size=preEnd-preStart+1;
        if(size==1) return node;
        if(size==2) node.left=new TreeNode(preorder[preStart+1]);
        else if(size==3){
            node.left=new TreeNode(preorder[preStart+1]);
            if(preorder[preStart+1]==postorder[postEnd-1]){
                node.left.left=new TreeNode(postorder[postStart]);
            }else node.right=new TreeNode(postorder[postEnd-1]);
        }else{
            int left=postMap[preorder[preStart+1]],leftSize=left-postStart;
            node.left=constructTree(preorder,postorder,preMap,postMap,preStart+1,preStart+1+leftSize,postStart,left);
            int right=preMap[postorder[postEnd-1]],rightSize=preEnd-right;
            if(right==preStart+1 && left==postEnd-1) return node;
            node.right=constructTree(preorder,postorder,preMap,postMap,right,preEnd,postEnd-1-rightSize,postEnd-1);
        }
        return node;
    }
}