class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i]=i/coins[0];
            else dp[0][i]=(int)(1e8);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int t=(int)(1e8);
                int nt=dp[i-1][j];
                if(j>=coins[i]) t=1+dp[i][j-coins[i]];
                dp[i][j]=Math.min(nt,t);
            }
        }
        int res=dp[n-1][amount];
        if(res>=(int)(1e8)) return -1;
        return res;
    }
}