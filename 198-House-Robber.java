class Solution {
    int res=-1;
    public int rob(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return generate(nums,n,n-1,dp);
    }
    public int generate(int[] nums,int n,int i,int[] dp){
        if(i<0) return 0;
        if(i==0) return nums[i];
        if(dp[i]!=-1) return dp[i];
        int pick = nums[i]+generate(nums,n,i-2,dp);
        int notPick = generate(nums,n,i-1,dp);
        return dp[i]=Math.max(pick,notPick);
    }
}