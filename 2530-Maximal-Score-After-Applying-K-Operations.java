class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int n : nums) pq.offer(n);
        long res=0;
        while(k-->0){
            int t=pq.poll(),n=(t+2)/3;
            pq.offer(n);
            res+=t;
        }
        return res;
    }
}