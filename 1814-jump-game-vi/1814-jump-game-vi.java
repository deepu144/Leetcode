class Solution {
    public int maxResult(int[] nums, int k) {
        Queue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.add(new int[]{nums[0],0});
        int max=nums[0],n=nums.length;
        for(int i=1;i<n;i++){ 
            while(pq.peek()[1]<i-k) pq.poll();
            max=pq.peek()[0]+nums[i];
            pq.add(new int[]{max,i});
        }
        return max;
    }
}