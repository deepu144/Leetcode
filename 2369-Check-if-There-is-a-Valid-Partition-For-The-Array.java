class Solution {
    public boolean validPartition(int[] nums) {
        return partition(nums,nums.length-1,new Boolean[nums.length]);
    }
    public boolean partition(int[] nums,int ind,Boolean[] dp){
        if((ind-1==0 && isValid(nums,ind-1,ind))||(ind-2==0 && isValid(nums,ind-2,ind))) return true;
        if(ind<0) return false;
        if(dp[ind]!=null) return dp[ind];
        boolean two=false,three=two;
        if(isValid(nums,ind-1,ind)) two=partition(nums,ind-2,dp);
        if(isValid(nums,ind-2,ind)) three=partition(nums,ind-3,dp);
        return dp[ind]=two||three;
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