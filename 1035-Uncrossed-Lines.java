class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        Integer[][] dp=new Integer[m+1][n+1];
        return cross(nums1,nums2,m-1,n-1,dp);
    }
    public int cross(int[] a,int[] b,int i,int j,Integer[][] dp){
        if(i==-1||j==-1) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(a[i]==b[j]) return dp[i][j]=1+cross(a,b,i-1,j-1,dp);
        return dp[i][j]=Math.max(cross(a,b,i-1,j,dp),cross(a,b,i,j-1,dp));
    }
}