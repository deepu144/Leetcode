class Solution {
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] adj=new List[n];
        List<Integer>[] actual=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=0;i<n;i++) actual[i]=new ArrayList<>();
        for(int[] a : connections){
            actual[a[0]].add(a[1]);
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        Set<Integer> set=new HashSet<>();
        int[] ans=new int[]{0};
        dfs(adj,0,set,actual,ans);
        return ans[0];
    }
    public void dfs(List<Integer>[] adj,int v,Set<Integer> set,List<Integer>[] actual,int[] ans){
        if(!set.add(v)) return;
        for(int i : adj[v]){
            if(!set.contains(i)){
                boolean f=false;
                for(int t : actual[i]){
                    if(t==v){
                        f=true;
                        break;
                    }
                }
                if(!f) ans[0]++;
                dfs(adj,i,set,actual,ans);
            }
        }
    }
}