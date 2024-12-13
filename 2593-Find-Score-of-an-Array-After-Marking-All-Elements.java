class Solution {
    public long findScore(int[] nums) {
        final int n=nums.length;
        int[][] pq=new int[n][];
        long ans=0L;
        boolean[] visit=new boolean[n];
        for(int i=0;i<n;i++) pq[i]=new int[]{nums[i],i};
        Arrays.sort(pq,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        for(int[] a : pq){
            if(visit[a[1]]) continue;
            ans+=a[0];
            visit[a[1]]=true;
            int ind=a[1];
            if(ind-1>=0) visit[ind-1]=true;
            if(ind+1<n) visit[ind+1]=true;
        }
        return ans;
    }
}