class Solution {
    final int[][] dir={{0,1},{1,0}};
    public long minCost(int m, int n, int[][] waitCost) {
        return helper(m,n,waitCost,0,0,new Long[m][n]);
    }
    public long helper(int r,int c,int[][] waitCost,int i,int j,Long[][] dp){
        if(i==r-1 && j==c-1) return 1L-waitCost[0][0];
        long min=Long.MAX_VALUE;
        if(dp[i][j]!=null) return dp[i][j];
        for(int[] d : dir){
            int x=d[0]+i;
            int y=d[1]+j;
            if(x>=r||y>=c) continue;
            long res = waitCost[i][j] + (x+1)*(y+1) + helper(r,c,waitCost,x,y,dp);
            min = Math.min(min,res);
        }
        return dp[i][j]=min;
    }
}