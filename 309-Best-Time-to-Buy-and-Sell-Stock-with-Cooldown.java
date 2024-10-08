class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n+2][2];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                int profit=(int)(-1e8);
                if(j==1){
                    int buyStock = -arr[i] + dp[i+1][0];
                    int notBuyStock = dp[i+1][1];
                    profit=Math.max(buyStock,notBuyStock);
                }else{
                    int sellStock=(int)(-1e9);
                    sellStock=arr[i]+dp[i+2][1];
                    int notSellStock = dp[i+1][0];
                    profit=Math.max(sellStock,notSellStock);
                }
                dp[i][j]=profit;
            }
        }
        return dp[0][1];
    }
}