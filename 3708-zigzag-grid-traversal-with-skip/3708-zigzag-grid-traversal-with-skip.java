class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        List<Integer> res=new ArrayList<>();
        boolean canAdd=true;
        for(int i=0;i<r;i++){
            if((i&1)==0){
                for(int j=0;j<c;j++){
                    if(canAdd) res.add(grid[i][j]);
                    canAdd=!canAdd;
                }
            }else{
                for(int j=c-1;j>=0;j--){
                    if(canAdd) res.add(grid[i][j]);
                    canAdd=!canAdd;
                }
            }
        }
        return res;
    }
}