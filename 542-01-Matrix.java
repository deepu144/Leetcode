class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int m=mat.length,n=mat[0].length,ones=0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    visited[i][j]=true;
                }else ones++;
            }
        }
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int[] d : dir){
                int x = d[0]+p.i;
                int y = d[1]+p.j;
                if(x<0 || x>=m || y<0 || y>=n || visited[x][y] || mat[x][y]==0) continue;
                mat[x][y]=p.d+1;
                q.offer(new Pair(x,y,p.d+1));
                visited[x][y]=true;
            }
        }
        return mat;
    }
}
class Pair{
    int i,j,d;
    public Pair(int i,int j,int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}