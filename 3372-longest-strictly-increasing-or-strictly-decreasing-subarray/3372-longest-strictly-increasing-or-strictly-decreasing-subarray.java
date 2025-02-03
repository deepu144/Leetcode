class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length,count1=1,count2=1,max=1;
        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i]){
                count1++;
                max=Math.max(max,count1);
            }else count1=1;
            if(nums[i-1]>nums[i]){
                count2++;
                max=Math.max(max,count2);
            }else count2=1;
        }
        return max;
    }
}