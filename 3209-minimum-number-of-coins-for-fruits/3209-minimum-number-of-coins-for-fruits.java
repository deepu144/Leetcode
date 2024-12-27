class Solution {
    public int minimumCoins(int[] prices) {
        int n=prices.length;
        return subsequence(prices,n,0,new Integer[n]);
    }
    public int subsequence(int[] prices,int n,int i,Integer[] dp) {
        if(i>=n) return 0;
        if(dp[i]!=null) return dp[i];
        int min=Integer.MAX_VALUE,range=Math.min(n,2*i+2);
        for(int k=i+1;k<=range;k++){
            int pick=subsequence(prices,n,k,dp);
            min=Math.min(pick,min);
        }
        dp[i]=prices[i]+(min==Integer.MAX_VALUE?0:min);
        return dp[i]=min+prices[i];
    }
}