class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pro=1,zero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) pro*=nums[i];
            else zero++; 
        } 
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0 && zero>=1) nums[i]=0;
            else if(nums[i]!=0 && zero==0) nums[i]=(pro/nums[i]);
            else if(nums[i]==0 && zero==1) nums[i]=pro;
            else if(nums[i]==0 && zero>1) nums[i]=0;
        }
        return nums;
    }
}