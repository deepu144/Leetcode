class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int n=nums.length;
        long ans=0;
        int[][] hash=new int[n][];
        for(int i=0;i<n;i++) hash[i]=new int[]{nums[i],i,0};
        for(int[] a : hash) pq.offer(a);
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            if(a[2]==1) continue;
            ans+=a[0];
            int ind=a[1];
            if(ind-1>=0) hash[ind-1][2]=1;
            if(ind+1<n) hash[ind+1][2]=1;
        }
        return ans;
    }
}