class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color=new int[n+1];
        List<Integer>[] adj=new List[n+1];
        for(int i=1;i<=n;i++) adj[i]=new ArrayList<>();
        for(int[] a : dislikes){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        for(int i=1;i<n;i++) if(color[i]==0) if(!dfs(adj,i,1,color)) return false;
        return true;
    }
    public boolean dfs(List<Integer>[] adj,int v,int pc,int[] color){
        color[v]=pc;
        for(int i : adj[v]){
            if(color[i]==0){
                if(!dfs(adj,i,pc==1?2:1,color)) return false;
            }
            else if(color[i]==pc) return false;
        }
        return true;
    }
}