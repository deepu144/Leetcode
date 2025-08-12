class Solution {
    public static final int MOD=(int)(1e9+7);
    public int numberOfWays(int n, int x) {
        int size = (int) Math.floor(Math.pow(n, 1.0 / x)) + 1;
        int[] nums = new int[size];
        for(int i=1;i<=size;i++) nums[i-1]=(int)Math.pow(i,x);
        return helper(nums,size-1,n,new Integer[size][n+1]);
    }
    public int helper(int[] nums,int i,int sum,Integer[][] dp){
        if(i==-1) return sum==0?1:0;
        if(dp[i][sum]!=null) return dp[i][sum];
        int notPick=helper(nums,i-1,sum,dp);
        int pick=0;
        if(sum-nums[i]>=0) pick=helper(nums,i-1,sum-nums[i],dp);
        return dp[i][sum]=(pick+notPick)%MOD;
    }
}