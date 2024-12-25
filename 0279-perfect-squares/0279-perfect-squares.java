class Solution {
    public int numSquares(int n) {
        int sqrt=(int)Math.sqrt(n);
        int[] nums=new int[sqrt];
        for(int i=1;i<=sqrt;i++) nums[i-1]=i*i;
        return sum(nums,sqrt-1,n,new Integer[sqrt][n+1]);
    }
    public int sum(int[] nums,int i,int sum,Integer[][] dp){
        if(i==-1) return sum==0?0:(int)(1e8);
        if(dp[i][sum]!=null) return dp[i][sum];
        int notPick=sum(nums,i-1,sum,dp);
        int pick=(int)(1e8);
        if(sum-nums[i]>=0) pick=1+sum(nums,i,sum-nums[i],dp);
        return dp[i][sum]=Math.min(pick,notPick);
    }
}