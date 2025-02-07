class Solution {
    int res=(int)(1e9);
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] adj=new List[n];
        int[] degree=new int[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) if(degree[i]==1) q.offer(i);
        byte[] visited=new byte[n];
        while(!q.isEmpty()){
            int u=q.poll();
            visited[u]=1;
            for(int v : adj[u]){
                degree[v]--;
                if(degree[v]==1) q.offer(v);
            }
        }
        int min=(int)(1e9);
        for(int i=0;i<n;i++) if(visited[i]!=1 && degree[i]!=0) min=Math.min(min,bfs(adj,i,visited,n));
        return min==(int)(1e9)?-1:min;
    }
    public int bfs(List<Integer>[] adj,int u,byte[] visited,int n){
        Queue<int[]> q=new LinkedList<>();
        int[] depth=new int[n];
        q.offer(new int[]{u,1,-1});//{node,depth,parent}
        depth[u]=1;
        int min=(int)(1e9);
        while(!q.isEmpty()){
            int[] p=q.poll();
            for(int v : adj[p[0]]){
                if(visited[v]!=1 && depth[v]==0){
                    depth[v]=p[1]+1;
                    q.offer(new int[]{v,p[1]+1,p[0]});
                }else if(visited[v]!=1 && v!=p[2]) min=Math.min(min,p[1]+depth[v]-1);
            }
        }
        return min;
    }
}