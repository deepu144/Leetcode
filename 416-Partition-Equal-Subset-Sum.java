class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for(int i=0;i<n;i++) sum+=nums[i];
        if(sum%2==1) return false;
        return subset(n,nums,sum/2,n-1,new Boolean[n][sum/2+1]);
    }
    public boolean subset(int n,int[] arr,int sum,int i,Boolean[][] dp){
        if(sum==0) return true;
        if(i==-1) return false;
        if(dp[i][sum]!=null) return dp[i][sum];
        boolean nt = subset(n,arr,sum,i-1,dp);
        boolean t = false;
        if(sum>=arr[i]) t=subset(n,arr,sum-arr[i],i-1,dp);
        return dp[i][sum]=t||nt;
    }
}