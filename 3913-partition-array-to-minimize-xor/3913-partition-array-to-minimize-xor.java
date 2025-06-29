class Solution {
    public int minXor(int[] nums, int k) {
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++) prefix[i]=(prefix[i-1] ^ nums[i]);
        return helper(nums,prefix,n,0,k,new Integer[n][k+1]);
    }
    public int helper(int[] nums,int[] prefix,int n,int st,int k,Integer[][] dp){
        if(st==n){
            if(k>0) return (int)(1e10);
            return 0;
        }
        if(k==0) return (int)(1e10);
        if(dp[st][k]!=null) return dp[st][k];
        int min=(int)(1e10);
        for(int i=st;i<n;i++){
            int curr = prefix[i] ^ (st > 0 ? prefix[st - 1] : 0);
            int a = helper(nums,prefix,n,i+1,k-1,dp);
            if(a>=(int)(1e10)) continue;
            min = Math.min(min,Math.max(curr,a));
        }
        return dp[st][k]=min;
    }
}