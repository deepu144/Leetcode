class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int[] hash=new int[n];
        for(int i : restricted) hash[i]=1;
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] a : edges){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        return 1+dfs(0,adj,hash,new boolean[n]);
    }
    public int dfs(int v,List<Integer>[] adj,int[] hash,boolean[] visited){
        visited[v]=true;
        int val=0;
        for(int i : adj[v]){
            if(!visited[i] && hash[i]==0) val += 1+dfs(i,adj,hash,visited);
        }
        return val;
    }
}