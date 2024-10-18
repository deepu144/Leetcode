class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        DisJointSet ds=new DisJointSet(n);
        for(int[] a : edges) ds.union(a[0],a[1]);
        int com=0;
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i){
                if((ds.size[i])*(ds.size[i]-1)==ds.edges[i]*2) com++;
            }
        }
        return com;
    }
}
class DisJointSet{
    int[] parent;
    int[] size;
    int[] edges;
    public DisJointSet(int n){
        parent=new int[n];
        size=new int[n];
        edges=new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++) parent[i]=i;
    }
    public int find(int u){
        if(parent[u]==u) return u;
        return parent[u]=find(parent[u]);
    }
    public boolean union(int u,int v){
        int ul_u=find(u);
        int ul_v=find(v);
        if(ul_u==ul_v){
            edges[ul_u]++;
            return false;
        }
        if(size[ul_u]>size[ul_v]){
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
            edges[ul_u]+=edges[ul_v]+1;
        }else{
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
            edges[ul_v]+=edges[ul_u]+1;
        }
        return true;
    }
}