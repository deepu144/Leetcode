class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        if(n==1) return n;
        int[] dp=new int[n];
        int[] cnt=new int[n];
        Arrays.fill(cnt,1);
        Arrays.fill(dp,1);
        int ans=-1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        cnt[i]=cnt[j];
                    }else if(dp[j]+1==dp[i]){
                        cnt[i]+=cnt[j];
                    }
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        int res=0;
        for(int i=0;i<n;i++) if(dp[i]==ans) res+=cnt[i];
        return res;
    }
}