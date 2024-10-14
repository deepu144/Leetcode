class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        return maxSum(arr,k,n-1,new Integer[n+1]);
    }
    public int maxSum(int[] arr,int k,int ind,Integer[] dp){
        if(ind==-1) return 0;
        if(dp[ind]!=null) return dp[ind];
        int maxi=-1,res=(int)(-1e7);
        for(int i=ind;i>=0;i--){
            int size=ind-i+1;
            if(size>k) break;
            maxi=Math.max(maxi,arr[i]);
            res=Math.max(res,(maxi*size)+maxSum(arr,k,i-1,dp));
        }
        return dp[ind]=res;
    }
}