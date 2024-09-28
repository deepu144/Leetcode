class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length,max=-1;
        DisjointSet ds = new DisjointSet(n*n);
        boolean[][] visited = new boolean[n][n];
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    visited[i][j]=true;
                    formCluster(grid,i,j,new LinkedList<>(List.of(new int[]{i,j})),visited,n,ds,dir);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    int s=1;
                    Set<Integer> t = new HashSet<>();
                    for(int[] a : dir){
                        int x = a[0]+i;
                        int y = a[1]+j;
                        if(x<0||y<0||x>=n||y>=n||grid[x][y]==0) continue;
                        int parent = ds.find(x*n+y);
                        if(t.add(parent)) s+=ds.size[parent];
                    }
                    max=Math.max(max,s);
                }
            }
        }
        return max==-1?n*n:max;
    }
    public void formCluster(int[][] grid,int i,int j,Queue<int[]> q,boolean[][] visited,int n,DisjointSet ds,int[][] dir){
        while(!q.isEmpty()){
            int[] pos = q.poll();
            for(int[] a : dir){
                int x = a[0]+pos[0];
                int y = a[1]+pos[1];
                if(x<0||x>=n||y<0||y>=n||visited[x][y]||grid[x][y]==0) continue;
                visited[x][y]=true;
                ds.union(i*n+j,x*n+y);
                q.offer(new int[]{x,y});
            }
        }
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