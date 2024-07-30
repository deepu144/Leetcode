class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int t=-1;
        boolean[][] ch = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && !ch[i][j]){
                    t=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=t;
                    ch[i][j]=true;
                    ch[j][i]=true;
                }
            }
        }
        int i=0;
        int a=0;
        int b=n-1;
        while(a<b){
            for(int j=0;j<n;j++){
                t=matrix[j][a];
                matrix[j][a]=matrix[j][b];
                matrix[j][b]=t;
            }
            a++;
            b--;
        }
    }
}