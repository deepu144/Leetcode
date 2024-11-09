class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] res=new int[n];
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] a : edges){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        int[] cnt=new int[26];
        dfs(adj,0,-1,cnt,res,labels);
        return res;
    }
    public void dfs(List<Integer>[] adj,int v,int parent,int[] cnt,int[] res,String s){
        char ch=s.charAt(v);
        int countBefore=cnt[ch-'a'];
        cnt[ch-'a']++;
        for(int i : adj[v]){
            if(parent!=i){
                dfs(adj,i,v,cnt,res,s);
            }
        }
        int countAfter=cnt[ch-'a'];
        res[v]=countAfter-countBefore;
    }
}