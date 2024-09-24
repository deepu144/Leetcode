class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        n++;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.d-b.d);
        List<int[]> adj[] = new List[n];
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] f : times) adj[f[0]].add(new int[]{f[1],f[2]});
        dist[src]=0;
        pq.offer(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            for(int[] a  : adj[p.v]){
                if(dist[a[0]]>p.d+a[1]){
                    dist[a[0]]=p.d+a[1];
                    pq.offer(new Pair(a[0],dist[a[0]]));
                }
            }
        }
        int max=-1;
        for(int i=1;i<n;i++) max=Math.max(dist[i],max);
        return max==Integer.MAX_VALUE?-1:max;
    }
}
class Pair{
    int v,d;
    Pair(int v,int d){
        this.v=v;
        this.d=d;
    }
}