class Solution {
    public int minZeroArray(int[] nums, int[][] queries){
        int st=0,end=queries.length-1,n=nums.length,nonZeros=0;
        for(int i=0;i<n;i++) if(nums[i]!=0) nonZeros++;
        if(nonZeros==0) return st;
        while(st<=end){
            int mid=(st+end)/2;
            if(canTransform(mid,queries,nums,n)) end=mid-1;
            else st=mid+1;
        }
        return st+1<=queries.length?st+1:-1;
    }
    public boolean canTransform(int n,int[][] queries,int[] nums,int m){
        int[] sweep=new int[m+1];
        for(int i=0;i<=n;i++){
            int[] query=queries[i];
            sweep[query[0]]+=query[2];
            sweep[query[1]+1]-=query[2];
        }
        for(int i=1;i<=m;i++) sweep[i]+=sweep[i-1];
        for(int i=0;i<m;i++) if(sweep[i]<nums[i]) return false;
        return true;
    }
}