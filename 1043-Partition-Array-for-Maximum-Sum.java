class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        return maxSum(arr,k,n,0,new Integer[n+1]);
    }
    public int maxSum(int[] arr,int k,int n,int ind,Integer[] dp){
        if(ind==n) return 0;
        if(dp[ind]!=null) return dp[ind];
        int maxi=-1,res=(int)(-1e7);
        for(int i=ind;i<n;i++){
            int size=i-ind+1;
            if(size>k) break;
            maxi=Math.max(maxi,arr[i]);
            res=Math.max(res,(maxi*size)+maxSum(arr,k,n,i+1,dp));
        }
        return dp[ind]=res;
    }
}