class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length,lvl=0;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{n-1,0});
        board[n-1][0]=-2;
        while(!q.isEmpty()){
            int size=q.size();
            lvl++;
            for(int i=0;i<size;i++){
                int[] p=q.poll();
                int num=((n-1-p[0])*n);
                if((n&1)==1) num+=((p[0]&1)!=1?p[1]:(n-1-p[1]));
                else num+=((p[0]&1)==1?p[1]:(n-1-p[1]));
                int loop=0;
                for(int j=1;j<=6;j++){
                    int val=num+j;
                    if(val>=(n*n)) break;
                    if(val==(n*n-1)) return lvl;
                    int row=(n-1)-(val/n);
                    int col=0;
                    if(n%2==0) col=(row&1)==1?val%n:(n-1-(val%n));
                    else col=(row&1)!=1?val%n:(n-1-(val%n));
                    if(board[row][col]==-2) continue;
                    if(board[row][col]!=-1){
                        int val1=board[row][col]-1;
                        if(val1==num) loop++;
                        if(val1==(n*n-1)) return lvl;
                        int row1=(n-1)-(val1/n);
                        int col1=0;
                        if(n%2==0) col1=(row1&1)==1?val1%n:(n-1-(val1%n));
                        else col1=(row1&1)!=1?val1%n:(n-1-(val1%n));
                        q.offer(new int[]{row1,col1});
                        board[row][col]=-2;
                    }else{
                        q.offer(new int[]{row,col});
                        board[row][col]=-2;
                    }
                }
                if(loop==6) return -1;
            }
        }
        return -1;
    }
}