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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    public TreeNode build(int[] nums,int start,int end){
        if(start>end) return null;
        int maxIndex=maxIndex(nums,start,end);
        TreeNode node=new TreeNode(nums[maxIndex]);
        node.left=build(nums,start,maxIndex-1);
        node.right=build(nums,maxIndex+1,end);
        return node;
    }
    public int maxIndex(int[] nums,int start,int end){
        int index=-1,max=-1;
        for(int i=start;i<=end;i++){
            if(max<nums[i]){
                max=nums[i];
                index=i;
            }
        }
        return index;
    }
}