class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        int[] inDegree=new int[n+1];
        int nodeWithTwoParent=-1;
        for(int[] a:edges){
            inDegree[a[1]]++;
            if(inDegree[a[1]]==2) nodeWithTwoParent=a[1];
        }
        if(nodeWithTwoParent==-1) return findRedundant(edges,nodeWithTwoParent,n);
        else{
            for(int i=n-1;i>=0;i--){
                if(edges[i][1]==nodeWithTwoParent){
                    int[] res=findRedundant(edges,i,n);
                    if(res==null) return edges[i];
                }
            }
        }
        return null;
    }
    public int[] findRedundant(int[][] edges,int nodeWithTwoParent,int n){
        DisJointSet ds=new DisJointSet(n+1);
        for(int i=0;i<n;i++){
            if(i==nodeWithTwoParent) continue;
            if(!ds.union(edges[i][0],edges[i][1])) return edges[i];
        }
        return null;
    }
}
class DisJointSet{
    int[] parent;
    int[] size;
    public DisJointSet(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        Arrays.fill(size,1);
    }
    public int find(int v){
        if(parent[v]==v) return v;
        return parent[v]=find(parent[v]);
    }
    public boolean union(int u,int v){
        int ul_u=find(u);
        int ul_v=find(v);
        if(ul_v==ul_u) return false;
        if(size[ul_u]<size[ul_v]){
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
        }else{
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
        }
        return true;
    }
}