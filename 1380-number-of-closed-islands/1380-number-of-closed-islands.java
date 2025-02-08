class Solution {
    final int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public int closedIsland(int[][] grid) {
        int r=grid.length,c=grid[0].length,res=0;
        boolean[][] visited=new boolean[r][c];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<r;i++){
            if(grid[i][0]==0 && !visited[i][0]){
                q.offer(new int[]{i,0});
                visited[i][0]=true;
            }
            if(grid[i][c-1]==0 && !visited[i][c-1]){
                q.offer(new int[]{i,c-1});
                visited[i][c-1]=true;
            }
        }
        for(int i=0;i<c;i++){
            if(grid[0][i]==0 && !visited[0][i]){
                q.offer(new int[]{0,i});
                visited[0][i]=true;
            }
            if(grid[r-1][i]==0 && !visited[r-1][i]){
                q.offer(new int[]{r-1,i});
                visited[r-1][i]=true;
            }
        }
        while(!q.isEmpty()){
            int[] p=q.poll();
            for(final int[] a : dir){
                int x=a[0]+p[0];
                int y=a[1]+p[1];
                if(x<0||y<0||x>=r||y>=c||grid[x][y]==1||visited[x][y]) continue;
                visited[x][y]=true;
                q.offer(new int[]{x,y});
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1 || visited[i][j]) continue;
                bfs(grid,i,j,visited,r,c);
                res++;
            }
        }
        return res;
    }
    public void bfs(int[][] grid,int ir,int jc,boolean[][] visited,int r,int c){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{ir,jc});
        visited[ir][jc]=true;
        while(!q.isEmpty()){
            int[] p=q.poll();
            for(final int[] a : dir){
                int x=a[0]+p[0];
                int y=a[1]+p[1];
                if(x<0||y<0||x>=r||y>=c||grid[x][y]==1||visited[x][y]) continue;
                visited[x][y]=true;
                q.offer(new int[]{x,y});
            }
        }
    }
}