class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum=0,n=nums.length;
        for(int i=0;i<n;i++){
            if(i-k<0){
                if(i+k>=n) sum+=nums[i];
                else if(nums[i+k]<nums[i]) sum+=nums[i];
            }else if(i+k>=n){
                if(i-k<0) sum+=nums[i];
                else if(nums[i-k]<nums[i]) sum+=nums[i];
            }else{
                if(nums[i-k]<nums[i] && nums[i+k]<nums[i]) sum+=nums[i];
            }
        }
        return sum;
    }
}