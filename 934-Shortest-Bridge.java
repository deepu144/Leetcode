class Solution {
    private final int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            boolean f=false;
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,n,q);
                    f=true;
                    break;
                }
            }
            if(f) break;
        }
        while(!q.isEmpty()){
            Pair p=q.poll();
            for(final int[] a : dir){
                int x=p.i+a[0];
                int y=p.j+a[1];
                if(x<0||y<0||x>=n||y>=n||grid[x][y]==2) continue;
                if(grid[x][y]==1) return p.d+1;
                q.offer(new Pair(x,y,p.d+1));
                grid[x][y]=2;
            }
        }
        return 0;
    }
    private void dfs(int[][] grid,int i,int j,int n,Queue<Pair> q){
        if(i<0||j<0||i>=n||j>=n||grid[i][j]==2) return;
        if(grid[i][j]==0){
            q.offer(new Pair(i,j,0));
            return;
        }
        grid[i][j]=2;
        for(final int[] a : dir) dfs(grid,i+a[0],j+a[1],n,q);
    }
}
class Pair{
    int i,j,d;
    public Pair(int _i,int _j,int _d){
        i=_i;
        j=_j;
        d=_d;
    }
}