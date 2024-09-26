class Solution {
    public int makeConnected(int n, int[][] con) {
        if(n-1 > con.length) return -1;
        DisjointSet ds = new DisjointSet(n);
        int wires=0;
        int notConnectedComputer = 0;
        for(int[] a : con) if(!ds.union(a[0],a[1])) wires++;
        for(int i=0;i<ds.size.length;i++) if(ds.parent[i]==i) notConnectedComputer++;
        int ans=notConnectedComputer-1;
        return wires>=ans?ans:-1;
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
    
    int find(int v){
        if(parent[v]==v) return v;
        return parent[v] = find(parent[v]);
    }
    
    boolean union(int u,int v){
        int ul_u = find(u);
        int ul_v = find(v);
        if(ul_u == ul_v) return false;
        
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