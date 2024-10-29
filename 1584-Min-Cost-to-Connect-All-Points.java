class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.d-b.d);
        int n=points.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                pq.offer(new Tuple(i,j,Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])));
            }
        }
        int min=0,edge=0;
        DisjointSet ds=new DisjointSet(n*n+1);
        while(!pq.isEmpty()){
            Tuple p=pq.poll();
            if(ds.union(p.i,p.j)){
                min+=p.d;
                edge++;
            }
            if(edge==n-1) return min;
        }
        return 0;
    }
}
class DisjointSet{
    int[] parent;
    int[] size;
    public DisjointSet(int n){
        parent=new int[n];
        size=new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++) parent[i]=i;
    }
    public int find(int v){
        if(parent[v]==v) return v;
        return parent[v]=find(parent[v]);
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
class Tuple{
    int i,j,d;
    public Tuple(int _i,int _j,int _d){
        i=_i;
        j=_j;
        d=_d;
    }
}