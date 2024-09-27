class Solution {
    public int numIslands(char[][] grid) {
        int r=grid.length,c=grid[0].length;
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int island=0;
        for(int i=0;i<r;i++) 
            for(int j=0;j<c;j++) 
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,r,c,dir);
                    island++;
                }
        return island;
    }
    public void dfs(char[][] grid,int r,int c,int m,int n,int[][] dir){
        grid[r][c]='+';
        for(int[] a : dir){
            int x = a[0]+r;
            int y = a[1]+c;
            if(x<0 || y<0 || x>=m || y>=n || grid[x][y]=='0'||grid[x][y]=='+') continue;
            dfs(grid,x,y,m,n,dir);
        }
    }
}