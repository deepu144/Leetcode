class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        List<int[]> li=new ArrayList<>();
        int m=nums1.length,n=nums2.length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums1[i]==nums2[j]) li.add(new int[]{i,j});
            }
        }
        int size=li.size();
        Integer[][] dp=new Integer[size][size+1];
        return cross(li,li.size()-1,-1,dp);
    }
    public int cross(List<int[]> li,int i,int prev,Integer[][] dp){
        if(i==-1) return 0;
        if(dp[i][prev+1]!=null) return dp[i][prev+1];
        int notPick = cross(li,i-1,prev,dp);
        int pick = (int)(-1e9);
        int[] curr=li.get(i);
        boolean f=true;
        if(prev!=-1){
            int[] a=li.get(prev);
            if((curr[0]==a[0])||(curr[1]==a[1])||(curr[0]>a[0] && curr[1]<a[1])||(curr[0]<a[0] && curr[1]>a[1])){
                f=false;
            }
        }
        if(f) pick=1 + cross(li,i-1,i,dp);
        return dp[i][prev+1]=Math.max(pick,notPick);
    }
}