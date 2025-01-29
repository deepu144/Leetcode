class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisJointSet alice=new DisJointSet(n+1);
        DisJointSet bob=new DisJointSet(n+1);
        int threeEdge=0;
        for(int[] a : edges){
            if(a[0]==3){
                int t=0;
                if(alice.union(a[1],a[2])) t++;
                if(bob.union(a[1],a[2])) t++;
                if(t==2) threeEdge++;
            }
        }
        for(int[] a : edges){
            if(a[0]==1) alice.union(a[1],a[2]);
            else if(a[0]==2) bob.union(a[1],a[2]);
        }
        int size1=alice.size[alice.find(edges[0][1])];
        int size2=bob.size[bob.find(edges[0][1])];
        if(size1!=n ||size2 !=n) return -1;
        return edges.length-(size1+size2-threeEdge-2);
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