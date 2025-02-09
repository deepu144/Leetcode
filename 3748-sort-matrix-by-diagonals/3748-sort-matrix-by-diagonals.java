class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        for(int i=0;i<n;i++){
            int r=i,c=0;
            List<Integer> li=new ArrayList<>();
            while(r<n){
                li.add(grid[r][c]);
                r++;
                c++;
            }
            Collections.sort(li,(a,b)->b-a);;
            r=i;c=0;
            for(int num : li) grid[r++][c++]=num;
        }
        for(int i=1;i<n;i++){
            int r=0,c=i;
            List<Integer> li=new ArrayList<>();
            while(c<n){
                li.add(grid[r][c]);
                r++;
                c++;
            }
            Collections.sort(li);
            r=0;c=i;
            for(int num : li) grid[r++][c++]=num;
        }
        return grid;
    }
}