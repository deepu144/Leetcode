class Solution {
    static final int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        int cnt=0;
        for(int[] a : walls) grid[a[0]][a[1]]=1;
        Queue<int[]> q = new LinkedList<>();
        for(int[] a : guards){
            grid[a[0]][a[1]]=2;
            for(int i=0;i<4;i++){
                int x = a[0]+dir[i][0];
                int y = a[1]+dir[i][1];
                if(x<0 || y<0 || x>=m || y>=n || grid[x][y]==1 || grid[x][y]==2) continue;
                q.offer(new int[]{x,y,i});
                grid[x][y]=3;
            }
        }
        while(!q.isEmpty()){
            int[] p = q.poll();
            int x = p[0] + dir[p[2]][0];
            int y = p[1] + dir[p[2]][1];
            if(x<0 || y<0 || x>=m || y>=n || grid[x][y]==1 || grid[x][y]==2) continue;
            q.offer(new int[]{x,y,p[2]});
            grid[x][y]=3;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
}