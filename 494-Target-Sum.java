class Solution {
    public int findTargetSumWays(int[] nums, int tar) {
        int n=nums.length,sum=0;
        for(int i=0;i<n;i++) sum+=nums[i];
        if (Math.abs(tar) > sum) return 0;
        return generate(nums,tar,n-1,new Integer[n][2*sum+1],sum);
    }
    public int generate(int[] nums,int tar,int i,Integer[][] dp,int offset){
        if(i==-1) return tar==0?1:0;
        int adjustedTar=tar+offset;
        if (adjustedTar < 0 || adjustedTar >= dp[0].length) return 0;
        if(dp[i][adjustedTar]!=null) return dp[i][adjustedTar];
        int left=generate(nums,tar-nums[i],i-1,dp,offset);
        int right=generate(nums,tar+nums[i],i-1,dp,offset);
        return dp[i][tar+offset]=left+right;
    }
}