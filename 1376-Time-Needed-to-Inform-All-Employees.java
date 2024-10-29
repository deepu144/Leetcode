class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] adj=new List[n+1];
        for(int i=0;i<=n;i++) adj[i]=new ArrayList<>();
        for(int i=0;i<manager.length;i++){
            if(manager[i]==-1) continue;
            adj[manager[i]].add(i);
        }
        return dfs(adj,headID,manager,informTime,new HashSet<>());
    }
    public int dfs(List<Integer>[] adj,int v,int[] manager,int[] time,Set<Integer> set){
        if(!set.add(v)) return 0;
        int max=0;
        for(int i : adj[v]){
            max=Math.max(max,time[v]+dfs(adj,i,manager,time,set));
        }
        return max;
    }
}