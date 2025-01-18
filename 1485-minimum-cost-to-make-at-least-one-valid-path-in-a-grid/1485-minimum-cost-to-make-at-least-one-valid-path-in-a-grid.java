class Solution {
    final int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public int minCost(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean[][] visit=new boolean[m][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] p=pq.poll();
            if(visit[p[0]][p[1]]) continue;
            visit[p[0]][p[1]]=true;
            if(p[0]==m-1 && p[1]==n-1) return p[2];
            for(int i=1;i<=4;i++){
                int[] a=dir[i-1];
                int x=a[0]+p[0];
                int y=a[1]+p[1];
                if(x<0||y<0||x>=m||y>=n||visit[x][y]) continue;
                pq.offer(new int[]{x,y,p[2]+(grid[p[0]][p[1]]==i?0:1)});
            }
        }
        return -1;
    }
}