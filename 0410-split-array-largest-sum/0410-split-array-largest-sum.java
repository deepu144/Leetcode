class Solution{
    public int splitArray(int[] nums, int k){
        int n=nums.length;
        return helper(nums,n,0,k,new Integer[n][k+1]);
    }
    public int helper(int[] nums,int n,int ind,int k,Integer[][] dp){
        if(k==0){
            if(ind==n) return 0;
            return (int)(1e9);
        }
        if(ind==n) return (int)(-1e9);
        if(dp[ind][k]!=null) return dp[ind][k];
        int curr=0,min=(int)(1e9);
        for(int i=ind;i<n;i++){
            curr+=nums[i];
            int res=Math.max(curr,helper(nums,n,i+1,k-1,dp));
            min=Math.min(min,res);
        }
        return dp[ind][k]=min;
    }
}