class Solution {
    public int maxProfit(int cap, int[] arr) {
        int n=arr.length;
        int[][][] dp=new int[n+1][2][cap+1];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                for(int k=1;k<=cap;k++){
                    int profit=(int)(-1e8);
                    if(j==1){
                        int buyStock = -arr[i] + dp[i+1][0][k];
                        int notBuyStock = dp[i+1][1][k];
                        profit=Math.max(buyStock,notBuyStock);
                    }else{
                        int sellStock=arr[i]+dp[i+1][1][k-1];
                        int notSellStock = dp[i+1][0][k];
                        profit=Math.max(sellStock,notSellStock);
                    }
                    dp[i][j][k]=profit;
                }
            }
        }
        return dp[0][1][cap];
    }
}