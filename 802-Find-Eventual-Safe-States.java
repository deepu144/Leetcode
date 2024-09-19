class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        boolean[] path = new boolean[V];
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!dfs(i,graph,new boolean[V],path)) res.add(i);
        }
        Collections.sort(res);
        return res;
    }
    public boolean dfs(int v,int[][] adj,boolean[] visit,boolean[] path){
        visit[v]=true;
        path[v]=true;
        for(int i : adj[v]){
            if(!visit[i]){
                if(dfs(i,adj,visit,path)) return true;
            }else if(path[i]) return true;
        }
        path[v]=false;
        return false;
    }
}