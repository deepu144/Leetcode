class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int[] hash=new int[n];
        for(int i : restricted) hash[i]=1;
        DisJointSet ds=new DisJointSet(n);
        for(int[] a : edges){
            if(hash[a[0]]==0 && hash[a[1]]==0) ds.union(a[0],a[1]);
        }
        return ds.size[ds.find(0)];
    }
}
class DisJointSet{
    int[] parent;
    int[] size;
    public DisJointSet(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        Arrays.fill(size,1);
    }
    public int find(int v){
        if(parent[v]==v) return v;
        return parent[v]=find(parent[v]);
    }
    public boolean union(int u,int v){
        int ul_u=find(u);
        int ul_v=find(v);
        if(ul_v==ul_u) return false;
        if(size[ul_u]<size[ul_v]){
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
        }else{
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
        }
        return true;
    }
}