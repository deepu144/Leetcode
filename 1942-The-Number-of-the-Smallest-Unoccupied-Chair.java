class Solution {
    public int smallestChair(int[][] times, int tar) {
        int n=times.length,ans=-1;
        int[] chair=new int[n];
        Arrays.fill(chair,-1);
        Tuple[] arr = new Tuple[n];
        for(int i=0;i<n;i++){
            arr[i]=new Tuple(times[i][0],times[i][1],i,-1);
        }
        Arrays.sort(arr,(a,b)->a.arrival-b.arrival);
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.leaving-b.leaving);
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() && pq.peek().leaving<=arr[i].arrival){
                chair[pq.poll().chair]=-1;
            }
            int minSeat=-1;
            for(int j=0;j<n;j++){
                if(chair[j]==-1){
                    minSeat=j;
                    break;
                }
            }
            Tuple t = arr[i];
            t.chair=minSeat;
            pq.offer(t);
            chair[minSeat]=arr[i].friend;
            if(t.friend==tar){
                ans=minSeat;
                break;
            }
        }
        return ans;
    }
}
class Tuple{
    int arrival,leaving,friend,chair;
    public Tuple(int arrival,int leaving,int friend,int chair){
        this.arrival=arrival;
        this.leaving=leaving;
        this.friend=friend;
        this.chair=chair;
    }
}