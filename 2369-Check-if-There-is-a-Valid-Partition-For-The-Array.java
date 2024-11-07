class Solution {
    public boolean validPartition(int[] nums) {
        int n=nums.length;
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<n;i++){
            if(isValid(nums,i-1,i) && i>=1) dp[i+1]|=dp[i-1];
            if(isValid(nums,i-2,i) && i>=2) dp[i+1]|=dp[i-2];
        }
        return dp[n];
    }
    public boolean isValid(int[] nums,int i,int j){
        int n=nums.length;
        if(i<0) return false;
        if(isSame(nums,i,j)) return true;
        if((j-i+1)!=3) return false;
        int st=nums[i]+1;
        for(int k=i+1;k<=j;k++){
            if(nums[k]==st) st++;
            else return false;
        }
        return true;
    }
    public boolean isSame(int[] nums,int i,int j){
        int t=nums[i];
        for(int k=i+1;k<=j;k++) if(nums[k]!=t) return false;
        return true;
    }
}