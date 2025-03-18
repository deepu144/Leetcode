class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n=nums.length,left=0,xor=nums[0],count=1;
        for(int right=1;right<n;right++){
            while((xor&nums[right])!=0) xor^=nums[left++];
            xor^=nums[right];
            count=Math.max(count,right-left+1);
        }
        return count;
    }
}