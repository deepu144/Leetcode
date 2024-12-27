class Solution {
    final int MOD=(int)(1e9+7);
    public int numRollsToTarget(int n, int k, int target) {
        return helper(n,k,target,new Integer[n+1][target+1]);
    }
    public int helper(int n,int k,int target,Integer[][] dp){
        if(n==0) return target==0?1:0;
        if(dp[n][target]!=null) return dp[n][target];
        long ways=0;
        for(int i=1;i<=k;i++){
            if(target-i>=0) ways=(ways+helper(n-1,k,target-i,dp))%MOD;
        }
        return dp[n][target]=(int)(ways%MOD);
    }
}