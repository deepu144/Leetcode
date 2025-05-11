class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        int[][] mat=new int[r+1][c+1];
        for(int i=0;i<r;i++){
            int sum=0;
            for(int j=0;j<c;j++){
                sum+=grid[i][j];
                mat[i+1][j+1]=sum+mat[i][j+1];
            }
            sum=0;
        }
        return isPartitionExistsInHorizontal(mat,r,c) || isPartitionExistsInVertical(mat,r,c);
    }
    public boolean isPartitionExistsInVertical(int[][] mat,int r,int c){
        int tot=mat[r][c];
        for(int j=1;j<c;j++){
            if(tot-mat[r][j]==mat[r][j]) return true;
        }
        return false;
    }
    public boolean isPartitionExistsInHorizontal(int[][] mat,int r,int c){
        int tot=mat[r][c];
        for(int i=1;i<r;i++){
            if(tot-mat[i][c]==mat[i][c]) return true;
        }
        return false;
    }
}