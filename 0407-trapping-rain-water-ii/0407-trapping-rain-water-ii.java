class Solution {
    final int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public int trapRainWater(int[][] height) {
        int r=height.length,c=height[0].length,water=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[][] visited=new boolean[r][c];
        for(int i=0;i<c;i++){
            pq.offer(new int[]{0,i,height[0][i]});
            pq.offer(new int[]{r-1,i,height[r-1][i]});
            visited[0][i]=true;
            visited[r-1][i]=true;
        }
        for(int i=1;i<r-1;i++){
            pq.offer(new int[]{i,0,height[i][0]});
            pq.offer(new int[]{i,c-1,height[i][c-1]});
            visited[i][0]=true;
            visited[i][c-1]=true;
        }
        while(!pq.isEmpty()){
            int[] p=pq.poll();
            for(int[] a : dir){
                int x=a[0]+p[0];
                int y=a[1]+p[1];
                if(x<0||y<0||x>=r||y>=c||visited[x][y]) continue;
                visited[x][y]=true;
                if(height[p[0]][p[1]]>height[x][y]){
                    water+=(height[p[0]][p[1]]-height[x][y]);
                    height[x][y]=height[p[0]][p[1]];
                }
                pq.offer(new int[]{x,y,height[x][y]});
            }
        }
        return water;
    }
}