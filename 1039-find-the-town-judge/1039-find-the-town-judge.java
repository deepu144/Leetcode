class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count=new int[n];
        for(int[] a : trust){
            count[a[0]-1]--;
            count[a[1]-1]++;
        }
        for(int i=0;i<n;i++) if(count[i]==n-1) return i+1;
        return -1;
    }
}