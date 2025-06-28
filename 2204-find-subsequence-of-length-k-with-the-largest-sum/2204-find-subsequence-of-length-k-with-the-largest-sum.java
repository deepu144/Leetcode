class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n=nums.length;
        int[][] arr=new int[n][2];
        int[] res=new int[k];
        for(int i=0;i<n;i++) arr[i]=new int[]{nums[i],i};
        Arrays.sort(arr,(a,b)->b[0]-a[0]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<k;i++) pq.offer(arr[i]);
        while(--k>=0) res[k]=pq.poll()[0];
        return res;
    }
}