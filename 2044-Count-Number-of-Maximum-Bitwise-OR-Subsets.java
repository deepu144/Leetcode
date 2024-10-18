class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int bit=0,n=nums.length;
        for(int i : nums) bit|=i;
        return subset(nums,n-1,0,bit);
    }
    public int subset(int[] nums,int i,int bit,int max){
        if(i==-1) return bit==max?1:0;
        int pick=subset(nums,i-1,bit|nums[i],max);
        int notPick=subset(nums,i-1,bit,max);
        return pick+notPick;
    }
}