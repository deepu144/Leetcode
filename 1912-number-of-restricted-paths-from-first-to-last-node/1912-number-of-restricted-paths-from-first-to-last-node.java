class Solution {
    final int MOD=(int)(1e9+7);
    public int countRestrictedPaths(int n, int[][] edges) {
        n+=1;
        int count=0;
        int[] degree=new int[n];
        List<int[]>[] adj=new List[n];
        for(int i=1;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] edge : edges){
            adj[edge[0]].add(new int[]{edge[1],edge[2]});
            adj[edge[1]].add(new int[]{edge[0],edge[2]});
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{n-1,0});
        dist[n-1]=0;
        while(!pq.isEmpty()){
            int[] p=pq.poll();
            for(int[] node : adj[p[0]]){
                if(dist[node[0]]>p[1]+node[1]){
                    dist[node[0]]=p[1]+node[1];
                    pq.offer(new int[]{node[0],dist[node[0]]});
                }
            }
        }
        return dfs(adj,1,dist,new Integer[n],n);
    }
    public int dfs(List<int[]>[] adj,int node,int[] dist,Integer[] dp,int n){
        if(node==n-1) return 1;
        if(dp[node]!=null) return dp[node];
        int sum=0;
        for(int[] a : adj[node]) if(dist[node]>dist[a[0]]) sum=(sum+dfs(adj,a[0],dist,dp,n))%MOD;
        return dp[node]=sum;
    }
}