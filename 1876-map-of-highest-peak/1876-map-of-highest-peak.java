class Solution {
    final int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] highestPeak(int[][] mat) {
        int r=mat.length,c=mat[0].length;
        boolean[][] visit=new boolean[r][c];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==1){
                    visit[i][j]=true;
                    mat[i][j]=0;
                    q.offer(new int[]{i,j,1});
                }
            }
        }
        while(!q.isEmpty()){
            int[] p=q.poll();
            for(int[] a : dir){
                int x=a[0]+p[0];
                int y=a[1]+p[1];
                if(x<0||y<0||x>=r||y>=c||visit[x][y]) continue;
                visit[x][y]=true;
                mat[x][y]=p[2];
                q.offer(new int[]{x,y,p[2]+1});
            }
        }
        return mat;
    }
}