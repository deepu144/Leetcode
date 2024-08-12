class KthLargest {
    PriorityQueue<Integer> pq=null;
    int k;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>(k);
        this.k=k;
        for(int n : nums) add(n);
    }
    
    public int add(int val) {
        if(pq.size()==k && pq.peek()<val) pq.poll();
        if(pq.size()<k) pq.offer(val);
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */