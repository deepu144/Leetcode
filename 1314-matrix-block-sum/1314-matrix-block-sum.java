class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int r = mat.length, c = mat[0].length;
        int[][] sum = new int[r+1][c+1];
        int[][] ans = new int[r][c];
        for(int i = 0; i < r; i++) {
            int curr = 0;
            for(int j = 0; j < c; j++) {
                curr += mat[i][j];
                sum[i+1][j+1] = curr + sum[i][j+1];
            }
        }
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                int r1 = i - k, c1 = j - k;
                int r2 = i + k, c2 = j + k;
                if(r1 < 0) r1 = 0;
                if(c1 < 0) c1 = 0;
                if(r2 >= r) r2 = r-1;
                if(c2 >=c) c2 = c-1;
                ans[i][j] = getSum(r1, c1, r2, c2, sum);
            }
        }
        return ans;
    }

    public int getSum(int r1, int c1, int r2, int c2, int[][] sum) {
        r1++; c1++; r2++; c2++;
        return sum[r2][c2] - sum[r1-1][c2] - sum[r2][c1-1] + sum[r1-1][c1-1];
    }

}