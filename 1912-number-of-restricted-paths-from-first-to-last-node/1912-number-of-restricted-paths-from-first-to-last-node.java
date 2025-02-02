class Solution {
    final int MOD=(int)(1e9+7);
    public int countRestrictedPaths(int n, int[][] edges) {
        n+=1;
        List<int[]>[] adj=new List[n];
        for(int i=1;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] edge : edges){
            adj[edge[0]].add(new int[]{edge[1],edge[2]});
            adj[edge[1]].add(new int[]{edge[0],edge[2]});
        }
        int[] dist=new int[n];
        int[] ways=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{n-1,0});
        dist[n-1]=0;
        ways[n-1]=1;
        while(!pq.isEmpty()){
            int[] p=pq.poll();
            if(p[1]>dist[p[0]]) continue;
            for(int[] node : adj[p[0]]){
                if(dist[node[0]]>p[1]+node[1]){
                    dist[node[0]]=p[1]+node[1];
                    pq.offer(new int[]{node[0],dist[node[0]]});
                }
                if(dist[node[0]]>dist[p[0]]){
                    ways[node[0]]=(ways[node[0]]+ways[p[0]])%MOD;
                }
            }
        }
        return ways[1];
    }
}