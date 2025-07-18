class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length,m=n/3;
        long[] prefix=new long[n];
        long[] suffix=new long[n];
        long min=(long)(1e14);
        getMax(suffix,nums,n,m);
        getMin(prefix,nums,n,m);
        for(int i=m-1;i<n-m;i++){
            min=Math.min(min,prefix[i]-suffix[i+1]);
        }
        return min;
    }
    public void getMin(long[] prefix,int[] nums,int n,int m){
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        long curr=0L;
        for(int i=0;i<n;i++){
            pq.offer(nums[i]);
            curr+=nums[i];
            if(pq.size()>m) curr-=pq.poll();
            prefix[i]=curr;
        }
    }
    public void getMax(long[] suffix,int[] nums,int n,int m){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long curr=0L;
        for(int i=n-1;i>=0;i--){
            pq.offer(nums[i]);
            curr+=nums[i];
            if(pq.size()>m) curr-=pq.poll();
            suffix[i]=curr;
        }
    }
}