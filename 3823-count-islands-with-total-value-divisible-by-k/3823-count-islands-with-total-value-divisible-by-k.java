class Solution {
    final int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public int countIslands(int[][] grid, int k) {
        int r=grid.length,c=grid[0].length,cnt=0;
        boolean[][] visited=new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(!visited[i][j] && grid[i][j]!=0){
                    if(helper(grid,r,c,i,j,visited)%k==0) cnt++;
                }
            }
        }
        return cnt;
    }
    public int helper(int[][] grid,int r,int c,int i,int j,boolean[][] visited){
        int sum=grid[i][j];
        visited[i][j]=true;
        for(int[] d : dir){
            int x=d[0]+i;
            int y=d[1]+j;
            if(x<0 || y<0 || x>=r || y>= c || visited[x][y] || grid[x][y]==0) continue;
            sum+=helper(grid,r,c,x,y,visited);
        }
        return sum;
    }
}