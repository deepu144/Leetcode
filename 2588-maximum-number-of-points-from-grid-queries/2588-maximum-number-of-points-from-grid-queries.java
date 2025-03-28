class Solution {
    final int[][] dir={{1,0},{0,1},{-1,0},{0,-1}}; 
    public int[] maxPoints(int[][] grid, int[] queries) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->grid[a[0]][a[1]]-grid[b[0]][b[1]]);
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int row=grid.length,col=grid[0].length,n=queries.length;
        boolean[][] visited=new boolean[row][col];
        int[] res=new int[n];
        int[][] q=new int[n][2];
        for(int i=0;i<n;i++){
            q[i][0]=queries[i];
            q[i][1]=i;
        }
        Arrays.sort(q,(a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0});
        visited[0][0]=true;
        int count=0,currQueryIndex=0;
        while(!pq.isEmpty() && currQueryIndex<n){
            int[] p=pq.peek();
            int x=p[0],y=p[1];
            if(grid[x][y]<q[currQueryIndex][0]){
                pq.poll();
                count++;
                for(int[] d : dir){
                    int a=d[0]+x;
                    int b=d[1]+y;
                    if(a>=row||a<0||b>=col||b<0||visited[a][b]) continue;
                    pq.offer(new int[]{a,b});
                    visited[a][b]=true;
                }
            }
            if(grid[x][y]>=q[currQueryIndex][0] || pq.isEmpty()){
                if(map.containsKey(q[currQueryIndex][0])){
                    res[q[currQueryIndex][1]]=map.get(q[currQueryIndex][0]);
                }else{
                    if(!map.isEmpty()){
                        int tot=count+map.get(map.lastKey());
                        res[q[currQueryIndex][1]]=tot;
                        map.put(q[currQueryIndex][0],tot);
                    }else{
                        res[q[currQueryIndex][1]]=count;
                        map.put(q[currQueryIndex][0],count);
                    }
                }
                count=0;
                currQueryIndex++;
            }
        }
        for(int i=currQueryIndex;i<n;i++) if(!map.isEmpty()) res[q[i][1]]=map.get(map.lastKey());
        return res;
    }
}