class Solution {
    private int timer=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> con) {
        List<Integer>[] adj = new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(List<Integer> li : con){
            int u=li.get(0),v=li.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,new boolean[n],bridges,adj,new int[n],new int[n]);
        return bridges;
    }
    public void dfs(int node, int parent, boolean[] visited, List<List<Integer>> bridges,List<Integer>[] adj,int[] time, int[] low){
        visited[node]=true;
        time[node]=low[node]=++timer;
        for(int i : adj[node]){
            if(i==parent) continue;
            if(!visited[i]){
                dfs(i,node,visited,bridges,adj,time,low);
                low[node]=Math.min(low[node],low[i]);
                if(time[node]<low[i]) bridges.add(new ArrayList(List.of(node,i)));
            }else low[node]=Math.min(low[node],low[i]);
        }
    }
}