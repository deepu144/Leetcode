class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n=nums.length;
        for(int i=1;i<n;i++) if((nums[i-1]&1)==(nums[i]&1)) return false;
        return true;
    }
}