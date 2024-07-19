class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> li = new ArrayList<>();
        int m = matrix.length;
        for(int i=0;i<m;i++){
            int min=Integer.MAX_VALUE,index=-1;
            for(int j=0;j<matrix[i].length;j++){
                if(min>matrix[i][j]){
                    min=matrix[i][j];
                    index=j;
                }
            }
            int max=-1;
            for(int j=0;j<m;j++){
                max=Math.max(max,matrix[j][index]);
            }
            if(max==min) li.add(max);
        }
        return li;
    }
}