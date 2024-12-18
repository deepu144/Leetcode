class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int max=right;
        for(int[] a : ranges) max=Math.max(a[1],max);
        int[] sweep=new int[max+2];
        for(int[] a : ranges){
            sweep[a[0]]++;
            sweep[a[1]+1]--;
        }
        for(int i=1;i<max+2;i++) sweep[i]+=sweep[i-1];
        for(int i=left;i<=right;i++) if(sweep[i]==0) return false;
        return true;
    }
}