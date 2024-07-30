class NumMatrix {
    private int[][] prefix;
    private int[][] matrix;
    private int row;
    private int col;
    public NumMatrix(int[][] matrix){
        this.matrix=matrix;
        prefix=new int[201][201];
        for(int i=0;i<matrix.length;i++){
            int sum=0;
            for(int j=0;j<matrix[i].length;j++){
                sum+=matrix[i][j];
                prefix[i+1][j+1]=prefix[i][j+1]+sum;
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2){
        return prefix[row2+1][col2+1]-prefix[row1][col2+1]-prefix[row2+1][col1]+prefix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */