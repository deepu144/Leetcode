class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0L;
        int min = (int)(1e9), negCnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] < 0){
                    negCnt++;
                    matrix[i][j] = -matrix[i][j];
                }
                sum += matrix[i][j]; 
                min = Math.min(min, matrix[i][j]);
            }
        }
        if(negCnt % 2 == 0) return sum;
        return sum - (min * 2L);
    }
}