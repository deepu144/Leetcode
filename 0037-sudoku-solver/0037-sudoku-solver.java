class Solution {
    final int N=9;
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isPossible(board,ch,i,j)){
                            board[i][j]=ch;
                            if(solve(board)) return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isPossible(char[][] board,char ch,int row,int col) {
        for(int i=0;i<N;i++){
            if(board[i][col]==ch) return false;
            if(board[row][i]==ch) return false;
        }
        int r=row-row%3,c=col-col%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++) if(board[i][j]==ch) return false;
        }
        return true;
    }
}