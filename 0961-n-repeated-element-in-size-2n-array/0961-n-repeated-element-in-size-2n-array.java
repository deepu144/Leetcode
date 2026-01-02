class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        if(nums[0] == nums[n-1]) return nums[0];
        for(int i=0;i<n-1;i++){
            if(nums[i] == nums[i+1]) return nums[i];
            if(i+2<n && nums[i] == nums[i+2]) return nums[i];
        }
        return -1;
    }
}