class Solution {
    public int maxSum(int[] nums) {
        int sum=0,pre=0,n=nums.length;
        boolean[] fre=new boolean[201];
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n;i++){
            int val=nums[i]+100;
            if(fre[val]) continue;
            pq.offer(val);
            fre[val]=true;
        }
        pre=pq.poll()-100;
        sum=pre;
        while(!pq.isEmpty()){
            sum+=(pq.poll()-100);
            if(sum<pre) return pre;
            pre=sum;
        }
        return pre;
    }
}