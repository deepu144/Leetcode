class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] res=new int[n];
        List<Integer>[] adj=new List[n];
        Map<Integer,Integer> map=new HashMap<>();
        Integer[][] dp=new Integer[n][26];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] a : edges){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        dfs(adj,0,map,-1);
        map.put(0,-1);
        for(int i=0;i<n;i++) res[i]=dfs(adj,i,labels.charAt(i),labels,map.get(i),dp);
        return res;
    }
    public void dfs(List<Integer>[] adj,int v,Map<Integer,Integer> map,int parent){
        for(int i : adj[v]){
            if(i!=parent){
                map.put(i,v);
                dfs(adj,i,map,v);
            }
        }
    }
    public int dfs(List<Integer>[] adj,int v,char ch,String s,int parent,Integer[][] dp){
        if(dp[v][ch-'a']!=null) return dp[v][ch-'a'];
        int sum=s.charAt(v)==ch?1:0;
        for(int i : adj[v]){
            if(parent!=i){
                sum+=dfs(adj,i,ch,s,v,dp);
            }
        }
        return dp[v][ch-'a']=sum;
    }
}