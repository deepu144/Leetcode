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
    public TreeNode sortedArrayToBST(int[] nums) {
        return binarySearch(0,nums.length-1,nums);
    }
    public TreeNode binarySearch(int start,int end,int[] nums){
        if(start>end) return null;
        int mid=start+((end-start)>>1);
        TreeNode node=new TreeNode(nums[mid]);
        node.left=binarySearch(start,mid-1,nums);
        node.right=binarySearch(mid+1,end,nums);
        return node;
    }
}