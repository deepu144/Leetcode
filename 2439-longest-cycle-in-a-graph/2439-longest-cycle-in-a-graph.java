class Solution {
    int k=0;
    public int longestCycle(int[] edges) {
        int n=edges.length;
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=0;i<n;i++) if(edges[i]!=-1) adj[i].add(edges[i]);
        int max=-1;
        boolean[] visit=new boolean[n];
        int[] topo=new int[n];
        k=n-1;
        for(int i=0;i<n;i++) if(!visit[i]) dfs(adj,i,visit,topo);
        List<Integer>[] rAdj=new List[n];
        for(int i=0;i<n;i++) rAdj[i]=new ArrayList<>();
        for(int i=0;i<n;i++) for(int node : adj[i]) rAdj[node].add(i);
        Arrays.fill(visit,false);
        for(int node : topo){
            if(!visit[node]){
                max=Math.max(max,dfs1(rAdj,node,node,visit));
            }
        }
        return max;
    }
    public void dfs(List<Integer>[] adj,int node,boolean[] visit,int[] topo){
        visit[node]=true;
        for(int n : adj[node]) if(!visit[n]) dfs(adj,n,visit,topo);
        topo[k--]=node;
    }
    public int dfs1(List<Integer>[] adj,int start,int node,boolean[] visit){
        if(visit[node]) return node==start?0:(int)(-1e9);
        visit[node]=true;
        int max=(int)(-1e9);
        for(int n : adj[node]){
            int res=1+dfs1(adj,start,n,visit);
            if(res>0) max=Math.max(max,res);
        }
        return max;
    }
}