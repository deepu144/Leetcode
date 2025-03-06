class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length,repeat=-1;
        Set<Integer> set=new HashSet<>();
        for(int i=1;i<=n*n;i++) set.add(i);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!set.remove(grid[i][j])) repeat=grid[i][j];
            }
        }
        int miss=-1;
        for(int num : set) miss=num;
        return new int[]{repeat,miss};
    }
}