class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] rich : richer) adj[rich[1]].add(rich[0]);
        int[] res=new int[n];
        Integer[] dp=new Integer[n];
        for(int i=0;i<n;i++) res[i]=dfs(adj,i,quiet,dp);
        return res;
    }
    public int dfs(List<Integer>[] adj,int node,int[] quiet,Integer[] dp){
        if(dp[node]!=null) return dp[node];
        int max=quiet[node],person=node;
        for(int neighbour : adj[node]){
            int t=dfs(adj,neighbour,quiet,dp);
            if(max>quiet[t]){
                max=quiet[t];
                person=t;
            }
        }
        return dp[node]=person;
    }
}