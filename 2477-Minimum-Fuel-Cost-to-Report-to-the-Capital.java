class Solution {
    long ans=0;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n=roads.length+1;
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] a : roads){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        Set<Integer> set=new HashSet();
        set.add(0);
        for(int i : adj[0]) dfs(adj,i,set,seats);
        return ans;
    }
    public int dfs(List<Integer>[] adj,int v,Set<Integer> set,int seat){
        set.add(v);
        int reps=1;
        for(int i : adj[v]){
            if(!set.contains(i)) reps+=dfs(adj,i,set,seat);
        }
        if(reps<=seat) ans++;
        else ans+=Math.ceil((double)reps/seat);
        return reps;
    }
}