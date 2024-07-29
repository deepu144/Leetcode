class Solution {
    int count=0;
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='.';
        NQueens(0,board,0,n);
        return count;
    }
    public void NQueens(int row,char[][] board,int q,int n){
        if(q==n){
            count++;
            return;
        }
        if(row>=n) return;
        for(int i=0;i<n;i++){
            if(validate(row,i,board,n)){
                board[row][i]='Q';
                q++;
                NQueens(row+1,board,q,n);
                q--;
                board[row][i]='.';
            }
        }
    }
    public boolean validate(int row,int col,char[][] board,int n){
        for(int i=0;i<n;i++){
            if(board[row][i]=='Q'|| board[i][col]=='Q') return false;
        }
        int a=row,b=col;
        while(a<n && b<n){
            if(board[a++][b++]=='Q') return false;
        }
        a=row;b=col;
        while(a>=0 && b>=0){
            if(board[a--][b--]=='Q') return false;
        }
        a=row;b=col;
        while(a<n && b>=0){
            if(board[a++][b--]=='Q') return false;
        }
        a=row;b=col;
        while(a>=0 && b<n){
            if(board[a--][b++]=='Q') return false;
        }
        return true;
    }
}