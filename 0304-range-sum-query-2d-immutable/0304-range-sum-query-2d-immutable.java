class NumMatrix {
    int[][] prefix;
    int row, col;

    public NumMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        prefix = new int[row+1][col+1];
        
        for(int i = 0; i < row; i++) {
            int sum = 0;
            for(int j = 0; j < col; j++) {
                sum += matrix[i][j];
                prefix[i+1][j+1] = sum + prefix[i][j+1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        return prefix[row2][col2] - prefix[row1-1][col2] - prefix[row2][col1-1] + prefix[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */