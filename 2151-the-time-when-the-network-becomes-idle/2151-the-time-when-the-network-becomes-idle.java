class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n=patience.length,max=(int)(-1e9);
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] a : edges){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{0,0});
        dist[0]=0;
        while(!pq.isEmpty()){
            int[] u=pq.poll();
            for(int v : adj[u[0]]){
                int d=u[1]+1;
                if(dist[v]>d){
                    dist[v]=d;
                    pq.offer(new int[]{v,dist[v]});
                }
            }
        }
        for(int i=0;i<n;i++){
            int tot=dist[i]*2;
            if(tot<=patience[i]) max=Math.max(max,tot);
            else{
                int created=((int)Math.ceil(tot/(patience[i]*1.0)))-1;
                max=Math.max(max,tot+(created*patience[i]));
            }
        }
        return max+1;
    }
}