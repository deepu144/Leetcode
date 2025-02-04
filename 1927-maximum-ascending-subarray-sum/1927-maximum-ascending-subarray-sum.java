class Solution {
    public int maxAscendingSum(int[] nums) {
        int tot=nums[0],sum=nums[0],n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i-1]>=nums[i]) sum=nums[i];
            else {
                sum+=nums[i];
                tot=Math.max(tot,sum);
            }
        }
        return tot;
    }
}