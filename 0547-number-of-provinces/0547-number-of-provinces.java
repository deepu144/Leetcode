class Solution {
    public int findCircleNum(int[][] m) {
        int provinces=0,n=m.length;
        DisJointSet ds=new DisJointSet(n);
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) if(m[i][j]==1) ds.union(i,j);
        for(int i=0;i<n;i++) if(ds.parent[i]==i) provinces++;
        return provinces;
    }
}
class DisJointSet{
    int[] parent;
    int[] size;
    public DisJointSet(int n){
        parent=new int[n];
        size=new int[n];
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
        if(ul_u==ul_v) return false;
        if(size[ul_u]>size[ul_v]){
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
        }else{
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
        }
        return true;
    }
}