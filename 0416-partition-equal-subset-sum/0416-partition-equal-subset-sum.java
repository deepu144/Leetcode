class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for(int i=0;i<n;i++) sum+=nums[i];
        if(sum%2==1) return false;
        return subset(nums,sum/2,n-1,new Boolean[n][sum/2+1]);
    }
    public boolean subset(int[] arr,int sum,int i,Boolean[][] dp){
        if(i==-1) return sum==0;
        if(dp[i][sum]!=null) return dp[i][sum];
        if(sum>=arr[i] && subset(arr,sum-arr[i],i-1,dp)) return dp[i][sum]=true;
        return dp[i][sum]=subset(arr,sum,i-1,dp);
    }
}