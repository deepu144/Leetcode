class Solution {
    int[] parent;
    int[] size;
    int componets;
    public int minCost(int n, int[][] edges, int k) {
        init(n);
        Arrays.sort(edges,(a,b)->a[2]-b[2]);
        if(n==k) return 0;
        for(int[] edge : edges){
            union(edge[0],edge[1]);
            if(componets==k) return edge[2];
        }
        return edges[edges.length-1][2];
    }
    public void init(int n){
        this.componets=n;
        this.parent=new int[n];
        this.size=new int[n];
        Arrays.fill(this.size,1);
        for(int i=0;i<n;i++) this.parent[i]=i;
    }
    public boolean union(int u,int v){
        int ul_u=find(u);
        int ul_v=find(v);
        if(ul_u==ul_v) return false;
        componets--;
        if(size[ul_u]>size[ul_v]){
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
        }else{
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
        }
        return true;
    }
    public int find(int u){
        if(parent[u]==u) return u;
        return parent[u]=find(parent[u]);
    }
}