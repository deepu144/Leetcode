class Solution {
    record Pair(long end,int room){}
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        int[] cnt = new int[n];
        PriorityQueue<Integer> rooms=new PriorityQueue<>();
        for(int i=0;i<n;i++) rooms.offer(i);
        int max=0,roomNo=(int)(1e9);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.end==b.end) return a.room-b.room;
            return Long.compare(a.end,b.end);
        });
        for(int[] meeting : meetings){
            long start=meeting[0], end=meeting[1], duration = end-start;
            while(!pq.isEmpty() && pq.peek().end <= start) rooms.offer(pq.poll().room);
            int room=0;
            if(!rooms.isEmpty()) room=rooms.poll();
            else{
                Pair p = pq.poll();
                room=p.room;
                start=p.end;
            }
            cnt[room]++;
            max=Math.max(max,cnt[room]);
            pq.offer(new Pair(start+duration,room));
        }
        for(int i=0;i<n;i++) if(max==cnt[i]) roomNo=Math.min(roomNo,i);
        return roomNo;
    }
}