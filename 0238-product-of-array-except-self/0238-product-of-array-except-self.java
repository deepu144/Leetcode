class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1, zeroCount = 0, n = nums.length;
        for(int num : nums) {
            if(num == 0) zeroCount++;
            else prod *= num;
            if(zeroCount > 1) 
                return new int[n];
        }
        for(int i = 0; i<n; i++) {
            if(nums[i] == 0) {
                nums[i] = prod;
                continue;
            }
            nums[i] = zeroCount == 1 ? 0 : prod / nums[i];
        }
        return nums;
    }
}