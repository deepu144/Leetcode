class Solution {
    record Tuple(int child,int st,int end){}
    public static int INF=(int)(1e9);
    public int minTime(int n, int[][] edges) {
        List<Tuple>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] edge : edges) adj[edge[0]].add(new Tuple(edge[1],edge[2],edge[3]));
        int[] dist=new int[n];
        Arrays.fill(dist,INF);
        dist[0]=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->dist[a]-dist[b]);
        pq.offer(0);
        while(!pq.isEmpty()){
            int node = pq.poll();
            if(node==n-1) return dist[node];
            for(Tuple p : adj[node]){
                if(dist[p.child]==INF){
                    if(p.st > dist[node]){
                        int waitingTime = p.st - dist[node];
                        dist[p.child] = waitingTime + dist[node] + 1;
                        pq.offer(p.child);
                    }
                    else if(dist[node] <= p.end){
                        dist[p.child] = dist[node]+1;
                        pq.offer(p.child);
                    }
                }else{
                    if(p.st > dist[node]){
                        int waitingTime = p.st - dist[node];
                        int d = waitingTime + dist[node] + 1;
                        if(dist[p.child] > d){
                            dist[p.child]=d;
                            pq.offer(p.child);
                        }
                    }else if(dist[node] <= p.end){
                        int d = dist[node]+1;
                        if(dist[p.child] > d){
                            dist[p.child]=d;
                            pq.offer(p.child);
                        }
                    }
                }
            }
        }
        return -1;
    }
}