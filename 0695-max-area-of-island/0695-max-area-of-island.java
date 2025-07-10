class Solution {
    final int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        DisJointSet ds = new DisJointSet(r*c);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int index = (c*i)+j;
                if(grid[i][j]==1){
                    for(int[] a : dir){
                        int x = a[0]+i;
                        int y = a[1]+j;
                        if(x<0 || y<0 || x>=r || y>=c || grid[x][y]==0) continue;
                        ds.union(index, (c*x)+y );
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    int index = (c*i)+j;
                    max=Math.max(max,ds.size[ds.find(index)]);
                }
            }
        }
        return max;
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