class Solution {
    public int[][] construct2DArray(int[] arr, int m, int n) {
        int len = arr.length;
        if(m*n!=len) return new int[][]{};
        int[][] res=new int[(int)(Math.ceil((double)len/n))][n];
        int a=0,b=0;
        for(int i=0;i<len;i++){
            res[a][b++]=arr[i];
            if(b==n){
                a++;
                b=0;
            }
        }
        return res;
    }
}