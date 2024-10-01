class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] t1=new int[n-1],t2=new int[n-1];
        for(int i=0;i<n;i++){
            if(i!=0) t1[i-1]=nums[i];
            if(i!=n-1) t2[i]=nums[i];
        }
        return Math.max(getMax(t1),getMax(t2));
    }
    public int getMax(int[] nums){
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1) pick+=dp[i-2];
            int notPick=dp[i-1];
            dp[i]=Math.max(pick,notPick);
        }
        return dp[n-1];
    }
}