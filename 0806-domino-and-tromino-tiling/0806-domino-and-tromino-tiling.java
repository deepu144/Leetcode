class Solution {
    static int[] dp=new int[1001];
    static boolean isComputed=false;
    final int MOD=(int)(1e9+7);
    public int numTilings(int n) {
        if(!isComputed){
            isComputed=true;
            helper();
        }
        return dp[n];
    }
    public void helper(){
        dp[0]=dp[1]=1;
        dp[2]=2;
        for(int i=3;i<1001;i++) dp[i] = ((dp[i-1] * 2)%MOD + dp[i-3])%MOD;
    }
}