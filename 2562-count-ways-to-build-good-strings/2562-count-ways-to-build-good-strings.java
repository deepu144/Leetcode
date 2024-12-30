class Solution {
    final int MOD=(int)(1e9+7);
    public int countGoodStrings(int low, int high, int zero, int one) {
        return helper(low,high,zero,one,0,new Integer[high+1]);
    }
    private int helper(int low, int high, int zero, int one, int currentLength,Integer[] dp) {
        if (currentLength > high) return 0;
        if(dp[currentLength]!=null) return dp[currentLength];
        int count = 0;
        if (currentLength >= low) count++;
        count = (count + helper(low, high, zero, one, currentLength + zero, dp))%MOD;
        count = (count + helper(low, high, zero, one, currentLength + one, dp))%MOD;
        return dp[currentLength]=count;
    }
}