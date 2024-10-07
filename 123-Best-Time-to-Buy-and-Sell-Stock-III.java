class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        return stock(prices,0,n,1,2,new Integer[n][2][3]);
    }
    public int stock(int[] arr,int i,int n,int buy,int cap,Integer[][][] dp){
        if(cap==0 || i==n) return 0;
        if(dp[i][buy][cap] != null) return dp[i][buy][cap];
        int profit=(int)(-1e8);
        if(buy==1){
            int buyStock = -arr[i] + stock(arr,i+1,n,0,cap,dp);
            int notBuyStock = stock(arr,i+1,n,1,cap,dp);
            profit=Math.max(buyStock,notBuyStock);
        }else{
            int sellStock=arr[i]+stock(arr,i+1,n,1,cap-1,dp);
            int notSellStock = stock(arr,i+1,n,0,cap,dp);
            profit=Math.max(sellStock,notSellStock);
        }
        return dp[i][buy][cap]=profit;
    }
}