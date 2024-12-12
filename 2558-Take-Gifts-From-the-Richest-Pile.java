class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        long ans=0;
        for(int i : gifts) pq.offer(i);
        while(k-->0) pq.offer((int)Math.sqrt(pq.poll()));
        for(int i : pq) ans+=i;
        return ans;
    }
}