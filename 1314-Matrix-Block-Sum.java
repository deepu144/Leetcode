class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] prefix = new int[201][201];
        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j=0;j<mat[i].length;j++){
                sum+=mat[i][j];
                prefix[i+1][j+1]=sum+prefix[i][j+1];
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                int rl=Math.max(i-k,0)+1,rh=Math.min(i+k,mat.length-1)+1,cl=Math.max(j-k,0)+1,ch=Math.min(j+k,mat[i].length-1)+1;
                mat[i][j]=prefix[rh][ch]-prefix[rl-1][ch]-prefix[rh][cl-1]+prefix[rl-1][cl-1];
            }
        }
        return mat;
    }
}