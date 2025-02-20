class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        return Math.max(getMax(nums,n,true),getMax(nums,n,false));
    }
    public int getMax(int[] nums,int n,boolean flag){
        int max=2;
        int[][] dp=new int[n][501];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int diff=0;
                if(flag) diff=nums[i]-nums[j];
                else diff=nums[j]-nums[i];
                if(diff<0) continue;
                dp[i][diff]=Math.max(dp[i][diff],dp[j][diff]+1);
                max=Math.max(max,dp[i][diff]);
            }
        }
        return max;
    }
}