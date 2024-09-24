class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.s-b.s);
        List<int[]> adj[] = new List[n];
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] f : flights) adj[f[0]].add(new int[]{f[1],f[2]});
        dist[src]=0;
        pq.offer(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(p.s>k) break;
            for(int[] a  : adj[p.v]){
                if(p.s<=k && dist[a[0]]>p.d+a[1]){
                    dist[a[0]]=p.d+a[1];
                    pq.offer(new Pair(a[0],dist[a[0]],p.s+1));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}
class Pair{
    int v,d,s;
    Pair(int v,int d,int s){
        this.v=v;
        this.d=d;
        this.s=s;
    }
}