class Solution {
    public int nearestExit(char[][] maze, int[] st) {
        int m=maze.length,n=maze[0].length;
        Queue<Pair> pq=new LinkedList<>();
        pq.offer(new Pair(st[0],st[1],0));
        maze[st[0]][st[1]]='+';
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            for(int[] d : dir){
                int x=p.i+d[0];
                int y=p.j+d[1];
                if(x<0||x>=m||y<0||y>=n||maze[x][y]=='+') continue;
                if(x==0||y==0||x==m-1||y==n-1) return p.d+1;
                else{
                    pq.offer(new Pair(x,y,p.d+1));
                    maze[x][y]='+';
                }
            }
        }
        return -1;
    }
}
class Pair{
    int i,j,d;
    public Pair(int _i,int _j,int _d){
        i=_i;
        j=_j;
        d=_d;
    }
}