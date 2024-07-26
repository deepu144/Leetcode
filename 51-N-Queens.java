class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='.';
        NQueens(0,board,0,ans,n);
        return ans;
    }

    public void NQueens(int row,char[][] board,int q,List<List<String>> ans,int n){
        if(q==n){
            ans.add(convert(board));
            return;
        }
        if(row>=n) return;
        for(int i=0;i<n;i++){
            if(validate(row,i,board,n)){
                board[row][i]='Q';
                q++;
                NQueens(row+1,board,q,ans,n);
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
    public ArrayList<String> convert(char[][] board){
        ArrayList<String> li = new ArrayList<>();
        for(char[] ch : board){
            li.add(new String(ch));
        }
        return li;
    }
}