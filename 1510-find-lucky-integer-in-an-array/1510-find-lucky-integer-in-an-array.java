class Solution {
    public int findLucky(int[] arr) {
        int[] fre = new int[501];
        for(int val : arr) fre[val]++;
        for(int i=500;i>=1;i--) if(fre[i]==i) return i;
        return -1;
    }
}