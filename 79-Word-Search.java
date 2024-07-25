class Solution {
    public boolean exist(char[][] board, String word) {
        int r=board.length,c=board[0].length,n=word.length();
        boolean[][] visited = new boolean[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++){
                if(board[i][j]==word.charAt(0) && check(0,i,j,r,c,board,word,visited)){
                    return true;
                }
            }
        return false;
    }
    public boolean check(int i,int r,int c,int row,int col,char[][] board,String word,boolean[][] visited){
        if(i==word.length()) return true;
        if(r<0||r>=row||c<0||c>=col||word.charAt(i)!=board[r][c]||visited[r][c]) return false;
        visited[r][c]=true;
        boolean check = check(i+1,r+1,c,row,col,board,word,visited) ||
                        check(i+1,r-1,c,row,col,board,word,visited) ||
                        check(i+1,r,c+1,row,col,board,word,visited) ||
                        check(i+1,r,c-1,row,col,board,word,visited);
        visited[r][c]=false;
        return check;
    }
}