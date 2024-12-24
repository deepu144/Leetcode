class Solution {
    final int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    public int getMaximumGold(int[][] grid) {
        int max=0,m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) max=Math.max(max,getPathSum(grid,i,j,n,m));
        }
        return max;
    }
    public int getPathSum(int[][] grid,int i,int j,int n,int m){
        int max=0;
        for(int[] a : dir){
            int x=a[0]+i;
            int y=a[1]+j;
            if(x<0||y<0||x>=m||y>=n||grid[x][y]==0) continue;
            int temp=grid[i][j];
            grid[i][j]=0;
            max=Math.max(max,getPathSum(grid,x,y,n,m));
            grid[i][j]=temp;
        }
        return max+grid[i][j];
    }
}