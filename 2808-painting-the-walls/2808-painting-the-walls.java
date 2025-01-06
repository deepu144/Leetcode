class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n=time.length,tot=0;
        return minAmount(cost,time,n,n,0,new Integer[n][n+1]);
    }
    public int minAmount(int[]cost,int[] time,int n,int remain,int i,Integer[][] dp){
        if(remain<=0) return 0;
        if(i==n) return (int)(1e9);
        if(dp[i][remain]!=null) return dp[i][remain];
        int paid=cost[i]+minAmount(cost,time,n,remain-1-time[i],i+1,dp);
        int notPick=minAmount(cost,time,n,remain,i+1,dp);
        return dp[i][remain]=Math.min(paid,notPick);
    }
}