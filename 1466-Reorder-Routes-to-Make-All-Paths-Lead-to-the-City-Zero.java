class Solution {
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] a : connections){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(-a[0]);
        }
        return dfs(adj,0,-1);
    }
    public int dfs(List<Integer>[] adj,int v,int prev){
        int cnt=0;
        for(final int i : adj[v]){
            if(Math.abs(i)==prev) continue;
            if(i>0) cnt++;
            cnt+=dfs(adj,Math.abs(i),v);
        }
        return cnt;
    }
}