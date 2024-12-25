class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int size=nums.size(),res=sum(nums,size-1,target,new Integer[size][target+1]);
        return res<0?-1:res;
    }
    public int sum(List<Integer> nums,int i,int sum,Integer[][] dp){
        if(i==-1) return sum==0?0:(int)(-1e8);
        if(dp[i][sum]!=null) return dp[i][sum];
        int notPick=sum(nums,i-1,sum,dp);
        int pick=(int)(-1e8);
        if(sum-nums.get(i)>=0) pick=1+sum(nums,i-1,sum-nums.get(i),dp);
        return dp[i][sum]=Math.max(pick,notPick);
    }
}