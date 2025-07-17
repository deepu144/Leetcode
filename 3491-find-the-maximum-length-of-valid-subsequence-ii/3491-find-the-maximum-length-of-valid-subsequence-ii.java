class Solution {
    public int maximumLength(int[] nums, int k) {
        return getMax(nums,nums.length,k);
    }
    public int getMax(int[] nums,int n,int k){
        int max=2;
        int[][] dp=new int[n][k+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int mod = (nums[i]+nums[j]) % k;
                dp[i][mod]=Math.max(dp[i][mod],dp[j][mod]+1);
                max=Math.max(max,dp[i][mod]);
            }
        }
        return max;
    }
}