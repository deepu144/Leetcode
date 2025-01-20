class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int r=mat.length,c=mat[0].length;
        int[] row=new int[r];
        int[] col=new int[c];
        Map<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) map.put(mat[i][j],new int[]{i,j});
        for(int i=0;i<arr.length;i++){
            int[] a=map.get(arr[i]);
            row[a[0]]++;
            col[a[1]]++;
            if(row[a[0]]==c||col[a[1]]==r) return i;
        }
        return -1;
    }
}