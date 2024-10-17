class Solution {
    public int maxDistance(int[][] grid) {
        int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int max=-1,water=0,land=0,n=grid.length;
        Queue<int[]> pq=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    land++;
                    pq.offer(new int[]{i,j,0});
                }
                else water++;
            }
        }
        if(land==n*n || water==n*n) return -1;
        while(!pq.isEmpty()){
            int size=pq.size();
            for(int i=0;i<size;i++){
                int[] p=pq.poll();
                for(int[] a : dir){
                    int x=a[0]+p[0];
                    int y=a[1]+p[1];
                    if(x<0||x>=n||y<0||y>=n||grid[x][y]==1) continue;
                    grid[x][y]=1;
                    pq.offer(new int[]{x,y,p[2]+1});
                }
            }
            max++;
        }
        return max;
    }
}