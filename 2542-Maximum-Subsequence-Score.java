class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++) arr[i]=new int[]{nums2[i],nums1[i]};
        Arrays.sort(arr,(a,b)->b[0]-a[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>(k,(a,b)->a-b);
        long sum=0,res=-1;
        for(int[] a:arr){
            sum+=a[1];
            pq.offer(a[1]);
            if(pq.size()>k) sum-=pq.poll();
            if(pq.size()==k) res=Math.max(res,sum*a[0]);
        }
        return res;
    }
}