class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        if(r<3||c<3) return 0;
        int res=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==5){
                    if(i-1>=0 && i+1<r && j-1>=0 && j+1<c){
                        Set<Integer> li = new HashSet<>();
                        if(!li.add(grid[i-1][j-1]) || (grid[i-1][j-1]<=0 || grid[i-1][j-1]>=10)) continue;
                        if(!li.add(grid[i-1][j])|| (grid[i-1][j]<=0 || grid[i-1][j]>=10)) continue;
                        if(!li.add(grid[i-1][j+1])|| (grid[i-1][j+1]<=0 || grid[i-1][j+1]>=10)) continue;
                        if(!li.add(grid[i][j-1])|| (grid[i][j-1]<=0 || grid[i][j-1]>=10)) continue;
                        if(!li.add(grid[i][j])|| (grid[i][j]<=0 || grid[i][j]>=10)) continue;
                        if(!li.add(grid[i][j+1])|| (grid[i][j+1]<=0 || grid[i][j+1]>=10)) continue;
                        if(!li.add(grid[i+1][j-1])|| (grid[i+1][j-1]<=0 || grid[i+1][j-1]>=10)) continue;
                        if(!li.add(grid[i+1][j])|| (grid[i+1][j]<=0 || grid[i+1][j]>=10)) continue;
                        if(!li.add(grid[i+1][j+1])|| (grid[i+1][j+1]<=0 || grid[i+1][j+1]>=10)) continue;
                        int r1=grid[i-1][j-1]+grid[i-1][j]+grid[i-1][j+1];
                        int r2=grid[i][j-1]+grid[i][j]+grid[i][j+1];
                        int r3=grid[i+1][j-1]+grid[i+1][j]+grid[i+1][j+1];
                        int c1=grid[i-1][j-1]+grid[i][j-1]+grid[i+1][j-1];
                        int c2=grid[i-1][j]+grid[i][j]+grid[i+1][j];
                        int c3=grid[i-1][j+1]+grid[i][j+1]+grid[i+1][j+1];
                        int d1=grid[i-1][j-1]+grid[i][j]+grid[i+1][j+1];
                        int d2=grid[i][j]+grid[i+1][j-1]+grid[i-1][j+1];
                        if(r1==15 && r2==15 && r3==15 && c1==15 && c2==15 && c3==15 && d1==15 && d2==15){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
    public boolean check(Set<Integer> li,int n){
        if(!li.add(n)) return false;
        if(n<=0 || n>=10) return false;
        return true;
    }
}