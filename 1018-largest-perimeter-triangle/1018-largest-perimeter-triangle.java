class Solution {
    public int largestPerimeter(int[] nums) {
        int n=nums.length,max=0;
        Arrays.sort(nums);
        for(int i=n-2;i>=1;i--){
            if(nums[i]+nums[i-1] > nums[i+1]) max = Math.max(max, nums[i]+nums[i-1]+nums[i+1]);
        }
        return max;
    }
}