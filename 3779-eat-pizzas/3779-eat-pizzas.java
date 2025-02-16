class Solution {
    public long maxWeight(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int val : nums) pq.offer(val);
        int n=nums.length,days=n/4;
        long res=0;
        int odd=(days&1)==1?(days+1)/2:days/2;
        int even=days-odd;
        while(odd-->0) res+=pq.poll();
        while(even-->0){
            pq.poll();
            res+=pq.poll();
        }
        return res;
    }
}