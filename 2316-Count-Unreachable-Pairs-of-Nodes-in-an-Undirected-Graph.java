class Solution {
    public long countPairs(int n, int[][] edges) {
        DisJointSet ds=new DisJointSet(n);
        long ans=0;
        for(int[] a : edges) ds.union(a[0],a[1]);
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i) li.add(ds.size[i]);
        }
        long sum=0;
        for(int size : li){
            ans+=sum*size;
            sum+=size;
        }
        return ans;
    }
}
class DisJointSet{
    int[] parent;
    int[] size;
    public DisJointSet(int n){
        parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        size=new int[n];
        Arrays.fill(size,1);
    }
    public int find(int v){
        if(v==parent[v]) return v;
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