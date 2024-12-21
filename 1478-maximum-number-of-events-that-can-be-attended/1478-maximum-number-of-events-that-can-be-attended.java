class Solution {
    final int N=100000;
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        int i=0,res=0,n=events.length;
        for(int day=1;day<=N;day++){
            while(!pq.isEmpty() && pq.peek()<day) pq.poll();
            while(i<n && events[i][0]==day) pq.offer(events[i++][1]);
            if(!pq.isEmpty()){
                pq.poll();
                res++;
            }
        }
        return res;
    }
}