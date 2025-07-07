class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int i=0,n=events.length,cnt=0;
        for(int day=1;day<=100000;day++){
            while(!pq.isEmpty() && day>pq.peek()) pq.poll();
            while(i<n && day==events[i][0]) pq.offer(events[i++][1]);
            if(!pq.isEmpty()){
                pq.poll();
                cnt++;
            }
        }
        return cnt;
    }
}