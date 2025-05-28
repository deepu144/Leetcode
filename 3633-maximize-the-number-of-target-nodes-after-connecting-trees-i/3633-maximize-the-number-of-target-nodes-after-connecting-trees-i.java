class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n=edges1.length+1,m=edges2.length+1;
        int[] tree1 = getCount(edges1,n,k);
        int[] tree2 = getCount(edges2,m,k-1);
        int max=0;
        for(int val : tree2) max=Math.max(max,val);
        int[] ans=new int[n];
        for(int i=0;i<n;i++) ans[i] = tree1[i]+max;
        return ans;
    }
    public int[] getCount(int[][] edges,int n,int k){
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] edge : edges){
            int u=edge[0],v=edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] count=new int[n];
        for(int i=0;i<n;i++) count[i] = dfs(adj,i,-1,k);
        return count;
    }
    public int dfs(List<Integer>[] adj,int node,int parent,int k){
        if(k==-1) return 0;
        int cnt=1;
        for(int neighbour : adj[node]){
            if(neighbour==parent) continue;
            cnt += dfs(adj,neighbour,node,k-1);
        }
        return cnt;
    }

}