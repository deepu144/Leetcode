class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length, min = (int)(1e9);
        for(int i=1;i<n;i++){
            for(int j=i+1;j<n;j++){
                min = Math.min(min,nums[i]+nums[j]);
            }
        }
        return min+nums[0];
    }
}