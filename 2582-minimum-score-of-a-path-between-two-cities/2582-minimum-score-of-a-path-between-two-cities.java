class Solution {
    public int minScore(int n, int[][] roads) {
        DisJointSet ds=new DisJointSet(n+1);
        int min=(int)(1e8);
        for(int[] a : roads) ds.union(a[0],a[1]);
        for(int[] a : roads) if(ds.find(1)==ds.find(a[1])) min=Math.min(min,a[2]);
        return min;
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