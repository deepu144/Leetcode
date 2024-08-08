class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int r, int c) {
        int n=1,d=1,count=1,j=0;
        boolean f=true;
        int[][] res=new int[rows*cols][2];
        res[j][0]=r;
        res[j++][1]=c;
        while(count<rows*cols){
            if(f){
                d=1;
                f=false;
            }
            else{
                d=-1;
                f=true;
            } 
            for(int i=0;i<n;i++){
                c+=d;
                if(r>=0 && r<rows && c<cols && c>=0){
                    res[j][0]=r;
                    res[j++][1]=c;
                    count++;
                }
            }
            for(int i=0;i<n;i++){
                r+=d;
                if(r>=0 && r<rows && c<cols && c>=0){
                    res[j][0]=r;
                    res[j++][1]=c;
                    count++;
                }
            }
            n++;
        }
        return res;
    }
}