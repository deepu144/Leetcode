class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edge, int[][] q) {
        int m=q.length,j=0,l=edge.length;
        int[][] queries=new int[m][4];
        boolean[] res=new boolean[m];
        DisJointSet ds=new DisJointSet(n);
        for(int i=0;i<m;i++){
            int[] p=q[i];
            queries[i]=new int[]{p[0],p[1],p[2],i};
        }
        Arrays.sort(queries,(a,b)->a[2]-b[2]);
        Arrays.sort(edge,(a,b)->a[2]-b[2]);
        for(int i=0;i<m;i++){
            int[] query=queries[i];
            while(j<l && edge[j][2]<query[2]){
                ds.union(edge[j][0],edge[j][1]);
                j++;
            }
            int ul_u=ds.find(query[0]);
            int ul_v=ds.find(query[1]);
            res[query[3]]=(ul_u==ul_v);
        }
        return res;
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