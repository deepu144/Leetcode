class Solution {
    final int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public int findMaxFish(int[][] grid) {
        int r=grid.length,c=grid[0].length,max=0;
        Queue<int[]> pq=new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]!=0) max=Math.max(max,dfs(grid,i,j,r,c));
            }
        }
        return max;
    }
    public int dfs(int[][] grid,int i,int j,int r,int c){
        if(i<0||j<0||i>=r||j>=c||grid[i][j]==0) return 0;
        int sum=grid[i][j];
        grid[i][j]=0;
        for(int[] a : dir){
            int x=a[0]+i;
            int y=a[1]+j;
            sum+=dfs(grid,x,y,r,c);
        }
        return sum;
    }
}