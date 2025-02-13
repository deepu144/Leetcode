class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        int n=nums.length,opertaions=0;
        for(int i : nums) pq.offer((long)i);
        while(pq.peek()<(long)k && pq.size()>1){
            long a=pq.poll(),b=pq.poll();
            pq.offer((a*2)+b);
            opertaions++;
        }
        return opertaions;
    }
}