class Solution {
    public int minFlips(int[][] grid) {
        return Math.min(countRow(grid),countCol(grid));
    }
    public int countRow(int[][] grid){
        int count=0,col=grid[0].length;;
        for(int[] arr : grid){
            int a=0,b=col-1;
            while(a<b) if(arr[a++]!=arr[b--]) count++;
        }
        return count;
    }
    public int countCol(int[][] grid){
        int count=0,row=grid.length,col=grid[0].length;
        for(int i=0;i<col;i++){
            int a=0,b=row-1;
            while(a<b) if(grid[a++][i]!=grid[b--][i]) count++;
        }
        return count;
    }
}