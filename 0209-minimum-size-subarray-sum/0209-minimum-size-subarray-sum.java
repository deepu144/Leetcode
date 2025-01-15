class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length,left=0,right=0,sum=0,min=(int)(1e9);
        while(right<n){
            sum+=nums[right];
            while(left<=right && sum>=target){
                min=Math.min(min,right-left+1);
                sum-=nums[left++];
            }
            right++;
        }
        return min==(int)(1e9)?0:min;
    }
}