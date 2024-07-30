class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length,n=mat[m-1].length;
        ArrayList<Integer>[] li = new ArrayList[m+n+1];
        for(int i=0;i<m+n+1;i++){
            li[i]=new ArrayList<>();
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<mat[i].length;j++){
                li[i+j].add(mat[i][j]);
                count++;
            }
        }
        int[] ans = new int[count];
        int i=0,j=0;
        for(ArrayList<Integer> t : li){
            if(i%2==0) Collections.reverse(t);
            for(int num : t) ans[j++]=num;
            i++;
        }
        return ans;
    }
}