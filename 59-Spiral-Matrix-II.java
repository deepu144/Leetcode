class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr=new int[n][n];
        rotate(arr,n,n,0,-1,0,1,1);
        return arr;
    }
    public void rotate(int[][] matrix,int nr,int nc,int r,int c,int dr,int dc,int val){
        if(nr==0 || nc==0) return;
        for(int i=0;i<nc;i++){
            r+=dr;
            c+=dc;
            matrix[r][c]=val++;
        }
        rotate(matrix,nc,nr-1,r,c,dc,-dr,val);
    }
}