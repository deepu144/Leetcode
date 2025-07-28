class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n=nums.length,or=0;
        for(int val : nums) or|=val;
        return helper(nums,n-1,or,0);
    }
    public int helper(int[] nums,int i,int target,int bit){
        if(i==-1) return (bit==target)?1:0;
        return helper(nums,i-1,target,bit|nums[i]) + helper(nums,i-1,target,bit);
    }
}