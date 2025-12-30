class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        if(r<3||c<3) return 0;
        int res=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==5 && i-1>=0 && i+1<r && j-1>=0 && j+1<c){
                    Set<Integer> li = new HashSet<>();
                    if(!li.add(grid[i-1][j-1]) || check(grid[i-1][j-1])) continue;
                    if(!li.add(grid[i-1][j])|| check(grid[i-1][j])) continue;
                    if(!li.add(grid[i-1][j+1])|| check(grid[i-1][j+1])) continue;
                    if(!li.add(grid[i][j-1])|| check(grid[i][j-1])) continue;
                    if(!li.add(grid[i][j])|| check(grid[i][j])) continue;
                    if(!li.add(grid[i][j+1])|| check(grid[i][j+1])) continue;
                    if(!li.add(grid[i+1][j-1])|| check(grid[i+1][j-1])) continue;
                    if(!li.add(grid[i+1][j])|| check(grid[i+1][j])) continue;
                    if(!li.add(grid[i+1][j+1])|| check(grid[i+1][j+1])) continue;
                    if(isSum15(grid[i-1][j-1]+grid[i-1][j]+grid[i-1][j+1]) &&
                        isSum15(grid[i][j-1]+grid[i][j]+grid[i][j+1]) &&
                        isSum15(grid[i+1][j-1]+grid[i+1][j]+grid[i+1][j+1]) &&
                        isSum15(grid[i-1][j-1]+grid[i][j-1]+grid[i+1][j-1]) &&
                        isSum15(grid[i-1][j]+grid[i][j]+grid[i+1][j]) &&
                        isSum15(grid[i-1][j+1]+grid[i][j+1]+grid[i+1][j+1]) &&
                        isSum15(grid[i-1][j-1]+grid[i][j]+grid[i+1][j+1]) &&
                        isSum15(grid[i][j]+grid[i+1][j-1]+grid[i-1][j+1])
                        ) {
                            res++;
                        }
                }
            }
        }
        return res;
    }
    public boolean check(int a){
        return a<=0 || a>=10;
    }
    public boolean isSum15(int val){
        return val==15;
    }
}