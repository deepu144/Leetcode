class Solution {
    public int removeStones(int[][] stones) {
        int maxCol=0,maxRow=0;
        for(int[] a : stones){
            maxCol=Math.max(maxCol,a[1]);
            maxRow=Math.max(maxRow,a[0]);
        }
        DisjointSet ds = new DisjointSet(maxCol+maxRow+2);
        for(int[] a : stones) ds.union(a[0],a[1]+maxRow+1);
        Set<Integer> uniqueComponents = new HashSet<>();
        for (int[] a : stones) uniqueComponents.add(ds.find(a[0]));
        return stones.length-uniqueComponents.size();
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
    
    void union(int u,int v){
        int ul_u = find(u);
        int ul_v = find(v);
        if(ul_u == ul_v) return;
        if(size[ul_u]<size[ul_v]){
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
        }else{
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
        }
    }
}