class Solution {
    public int minimumEffortPath(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.d-b.d);
        int[][] diff=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(diff[i],Integer.MAX_VALUE);
        diff[0][0]=0;
        pq.offer(new Pair(0,0,0));
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(p.i==m-1 && p.j==n-1) return p.d;
            for(int[] d : dir){
                int x=p.i+d[0];
                int y=p.j+d[1];
                if(x<0 || y<0 || x>=m || y>=n) continue;
                int ne=Math.max(p.d,Math.abs(grid[x][y]-grid[p.i][p.j]));
                if(ne<diff[x][y]){
                    diff[x][y]=ne;
                    pq.offer(new Pair(x,y,ne));
                }
            }
        }
        return -1;
    }
}
class Pair{
    int i,j,d;
    Pair(int i,int j,int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}