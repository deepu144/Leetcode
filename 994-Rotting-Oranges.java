class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<Pair> q = new ArrayDeque<>();
        int min=0,m=grid.length,n=grid[0].length;
        int temp=0;
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) if(grid[i][j]==2) q.offer(new Pair(i,j));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                int r=p.i,c=p.j;
                if((r+1>=0 && r+1<m) && (c>=0 && c<n)){
                    if(grid[r+1][c]==1){
                        q.offer(new Pair(r+1,c));
                        grid[r+1][c]=2;
                    }
                }
                if((r-1>=0 && r-1<m) && (c>=0 && c<n)){
                    if(grid[r-1][c]==1){
                        q.offer(new Pair(r-1,c));
                        grid[r-1][c]=2;
                    }
                }
                if((r>=0 && r<m) && (c+1>=0 && c+1<n)){
                    if(grid[r][c+1]==1){
                        q.offer(new Pair(r,c+1));
                        grid[r][c+1]=2;
                    }
                }
                if((r>=0 && r<m) && (c-1>=0 && c-1<n)){
                    if(grid[r][c-1]==1){
                        q.offer(new Pair(r,c-1));
                        grid[r][c-1]=2;
                    }
                }
            }
            if(temp!=0) min++;
            temp++;
        }
        if(isFresh(grid)) return -1;
        return min;
    }
    public boolean isFresh(int[][] arr){
        for(int[] a : arr) for(int i : a) if(i==1) return true;
        return false;
    }
}
class Pair{
    int i,j;
    public Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
