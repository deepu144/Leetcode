class Solution {
    int count=0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] a : edges){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        dfs(adj,0,-1,values,k);
        return count;
    }
    public long dfs(List<Integer>[] adj,int node,int parent,int[] values,int k){
        if(adj[node].size()==1 && adj[node].getFirst()==parent){
            if(values[node]%k==0){
                count++;
                return 0L;
            }
            return (long)values[node];
        }
        long sum=values[node];
        for(int n : adj[node]){
            if(n!=parent) sum+=dfs(adj,n,node,values,k);
        }
        if(sum%k==0){
            count++;
            return 0L;
        }
        return sum;
    }
}