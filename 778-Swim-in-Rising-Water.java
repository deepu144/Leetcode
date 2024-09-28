class Solution {
    record Pair(int x,int y){}
    public int swimInWater(int[][] grid) {
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        int n = grid.length,ans=grid[0][0];
        Queue<Pair> pq = new PriorityQueue<>((a,b)->grid[a.x][a.y]-grid[b.x][b.y]);
        Set<Pair> visited=new HashSet<>();
        pq.offer(new Pair(0,0));
        Pair end = new Pair(n-1,n-1);
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ans=Math.max(ans,grid[p.x][p.y]);
            if(p.equals(end)) return ans;
            for(int[] a : dir){
                int x = p.x+a[0];
                int y = p.y+a[1];
                if(x<0||y<0||x>=n||y>=n) continue;
                Pair pn = new Pair(x,y);
                if(visited.contains(pn)) continue;
                visited.add(pn);
                pq.offer(pn);
            }
        }
        return ans;
    }
}