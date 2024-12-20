class Solution {
    final int MOD=(int)(1e9+7);
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        final int n=nums.length;
        int[] sweep=new int[n+2];
        long[] premutation=new long[n];
        for(int[] a : requests){
            sweep[a[0]]++;
            sweep[a[1]+1]--;
        }
        Arrays.sort(nums);
        int j=n-1;
        for(int i=1;i<n;i++) sweep[i]+=sweep[i-1];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<n;i++) pq.offer(new int[]{i,sweep[i]});
        while(j>=0) premutation[pq.poll()[0]]=nums[j--];
        long res=0;
        for(int i=1;i<n;i++) premutation[i]+=premutation[i-1];
        for(int[] a : requests){
            if(a[0]>0) res+=(premutation[a[1]]-premutation[a[0]-1]);
            else res+=premutation[a[1]];
            res=res%MOD;
        }
        return (int)res%MOD;
    }
}