class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int)1e9+7;
        int m=roads.length;
        List<long[]>[] adj = new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] a : roads){
            adj[a[0]].add(new long[]{a[1],a[2]});
            adj[a[1]].add(new long[]{a[0],a[2]});
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.d,b.d));
        long[][] dist=new long[n][2];
        for(int i=1;i<n;i++) Arrays.fill(dist[i],Long.MAX_VALUE);
        dist[0][1]=1;
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(p.d>dist[p.v][0]) continue;
            for(long[] a : adj[p.v]){
                int nextNode = (int)a[0];
                long nextDist = p.d + a[1];
                if(nextDist < dist[nextNode][0]){
                    dist[nextNode][0] = nextDist;
                    dist[nextNode][1] = dist[p.v][1];
                    pq.offer(new Pair(nextNode, nextDist));
                } else if(nextDist == dist[nextNode][0]){
                    dist[nextNode][1] = (dist[nextNode][1] + dist[p.v][1]) % MOD;
                }
            }
        }
        return (int)dist[n-1][1];
    }
}
class Pair{
    int v;
    long d;
    Pair(int v,long d){
        this.v=v;
        this.d=d;
    }
}