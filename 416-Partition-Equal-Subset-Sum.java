class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for(int i=0;i<n;i++) sum+=nums[i];
        return subset(nums,n-1,sum,0,new Boolean[n][sum+1]);
    }
    public boolean subset(int[] nums,int i,int totalSum,int sum,Boolean[][] dp){
        if(sum==(totalSum-sum)) return true;
        if(i==-1 || sum>(totalSum-sum)) return false;
        if(dp[i][sum]!=null) return dp[i][sum];
        boolean nt=subset(nums,i-1,totalSum,sum,dp);
        boolean t=subset(nums,i-1,totalSum,sum+nums[i],dp);
        return dp[i][sum]=t||nt;
    }
}