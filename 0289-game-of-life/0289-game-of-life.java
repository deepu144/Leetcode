class Solution {
    final int[][] dir={{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        int r=board.length,c=board[0].length;
        int[][] liveCell=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==1){
                    for(int[] a : dir){
                        int x=a[0]+i;
                        int y=a[1]+j;
                        if(x<0||y<0||x>=r||y>=c) continue;
                        liveCell[x][y]++;
                    }
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==1 && (liveCell[i][j]<2 ||liveCell[i][j]>3)) board[i][j]=0;
                else if(board[i][j]==0 && liveCell[i][j]==3) board[i][j]=1;
            }
        }
    }
}