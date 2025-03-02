class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int n=original.length;
        int min=bounds[0][0],max=bounds[0][1];
        for(int i=1;i<n;i++){
            int diff=original[i]-original[i-1];
            min=Math.max(min+diff,bounds[i][0]);
            max=Math.min(max+diff,bounds[i][1]);
        }
        return min>max?0:max-min+1;
    }
}