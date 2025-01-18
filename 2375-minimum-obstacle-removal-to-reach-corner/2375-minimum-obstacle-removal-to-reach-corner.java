class Solution {
    final int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public int minimumObstacles(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] visit=new int[m][n];
        for(int[] a : visit) Arrays.fill(a,Integer.MAX_VALUE);
        Deque<int[]> queue=new ArrayDeque<>();
        queue.addFirst(new int[]{0,0,0});
        visit[0][0]=0;
        while(!queue.isEmpty()){
            int[] p=queue.pollFirst();
            for(int[] a : dir){
                int x=a[0]+p[0],y=a[1]+p[1];
                if(x<0||y<0||x>=m||y>=n) continue;
                int cost=p[2]+grid[x][y];
                if(cost<visit[x][y]){
                    visit[x][y]=cost;
                    if(grid[x][y]==0) queue.addFirst(new int[]{x,y,cost});
                    else queue.addLast(new int[]{x,y,cost});
                }
            }
        }
        return visit[m-1][n-1];
    }
}