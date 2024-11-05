class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<n;i++){
            if(i==left[i] || i==right[i]) return false;
            if(left[i]!=-1) if(!ds.union(i,left[i])) return false;
            if(right[i]!=-1) if(!ds.union(i,right[i])) return false;
        }
        boolean f=false;
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i){
                if(!f) f=true;
                else return false;
            }
        }
        return true;
    }
}
class DisjointSet{
    int[] parent;
    int[] size;
    DisjointSet(int n){
        parent=new int[n];
        size=new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++) parent[i]=i;
    }
    boolean isParent(int u,int v){
        if(parent[u]==u) return false;
        if(parent[u]==v) return true;
        return isParent(parent[u],v);
    }
    boolean union(int u,int v){
        if(parent[v]!=v || isParent(u,v)) return false;
        parent[v]=u;
        size[u]+=size[v];
        return true;
    }
}