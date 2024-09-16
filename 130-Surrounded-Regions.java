class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                q.offer(new int[]{i,0});
                visited[i][0]=true;
            }
            if(board[i][n-1]=='O'){
                q.offer(new int[]{i,n-1});
                visited[i][n-1]=true;
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O' && !visited[0][i]){
                q.offer(new int[]{0,i});
                visited[0][i]=true;
            }
            if(board[m-1][i]=='O' && !visited[m-1][i]){
                q.offer(new int[]{m-1,i});
                visited[m-1][i]=true;
            }
        }
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] a = q.poll();
            for(int[] d : dir){
                int x = d[0] + a[0];
                int y = d[1] + a[1];
                if(x<0 || x>=m || y<0 || y>=n || board[x][y]=='X' || visited[x][y]) continue;
                visited[x][y]=true;
                q.offer(new int[]{x,y});
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && !visited[i][j]) board[i][j]='X';
            }
        }
    }
}