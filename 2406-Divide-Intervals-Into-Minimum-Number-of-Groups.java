class Solution {
    public int minGroups(int[][] arr) {
        int max=0;
        for(int[] a : arr) max=Math.max(max,a[1]);
        int[] hash=new int[max+2];
        for(int[] a : arr){
            hash[a[0]]++;
            hash[a[1]+1]--;
        }
        int t=max;
        max=hash[0];
        for(int i=1;i<t;i++){
            hash[i]+=hash[i-1];
            max=Math.max(max,hash[i]);
        }
        return max==0?1:max;
    }
}