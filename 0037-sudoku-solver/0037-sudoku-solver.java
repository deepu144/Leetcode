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
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==ch) return false;
        }
        return true;
    }
}