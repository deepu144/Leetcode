class Solution {
    private final int[][] dir={{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        final int m=board.length,n=board[0].length;
        int[][] mat=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='M'){
                    mat[i][j]=-1;
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            final int[] p=q.poll();
            for(final int[] a : dir){
                final int x=a[0]+p[0];
                final int y=a[1]+p[1];
                if(x<0||y<0||x>=m||y>=n||mat[x][y]==-1) continue;
                mat[x][y]++;
            }
        }
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        if(mat[click[0]][click[1]]==0){
            board[click[0]][click[1]]='B';
            q.offer(new int[]{click[0],click[1]});
        }
        else board[click[0]][click[1]]=(char)(mat[click[0]][click[1]]+'0');
        while(!q.isEmpty()){
            final int[] p=q.poll();
            for(final int[] a : dir){
                final int x=a[0]+p[0];
                final int y=a[1]+p[1];
                if(x<0||y<0||x>=m||y>=n||board[x][y]=='B'||(board[x][y]>'0' && board[x][y]<'9')||board[x][y]=='M') continue;
                if(mat[x][y]==0){
                    q.offer(new int[]{x,y});
                    board[x][y]='B';
                }else board[x][y]=(char)(mat[x][y]+'0');
            }
        }
        return board;
    }
}