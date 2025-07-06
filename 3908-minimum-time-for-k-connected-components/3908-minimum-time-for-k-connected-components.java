class Solution {
    int[] parent;
    int[] size;
    int[] component;
    int k;
    public int minTime(int n, int[][] edges, int k) {
        init(n);
        this.k=k;
        Arrays.sort(edges,(a,b)->a[2]-b[2]);
        int m=edges.length;
        if(k==n) return m>0 ? edges[m-1][2] : 0;
        for(int i=m-1;i>=0;i--){
            int res = union(edges[i][0],edges[i][1]);
            if(res>0) return edges[i][2];
        }
        return 0;
    }
    public void init(int n){
        this.parent=new int[n];
        this.size=new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++) parent[i]=i;
        this.component=new int[1];
        this.component[0]=n;
    }
    public int find(int u){
        if(parent[u]==u) return u;
        return parent[u]=find(parent[u]);
    }
    public int union(int u,int v){
        int ul_u=find(u);
        int ul_v=find(v);
        if(ul_u==ul_v) return -1;
        component[0]--;
        if(component[0]+1==k) return 1;
        if(size[ul_u]>size[ul_v]){
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
        }else{
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
        }
        return -1;
    }
}