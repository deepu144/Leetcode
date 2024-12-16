class Solution {
    public int[] getFinalState(int[] nums, int k, int mul) {
        while(k!=0){
            int min=Integer.MAX_VALUE;
            for(int n : nums) min=Math.min(min,n);
            for(int i=0;i<nums.length;i++){
                if(nums[i]==min){
                    nums[i]*=mul;
                    break;
                }
            }
            k--;
        }
        return nums;
    }
}