class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lMax = 0, rMin=100000;
        for(int val : right) rMin = Math.min(rMin,val);
        for(int val : left) lMax = Math.max(val,lMax);
        return Math.max(lMax,n-rMin);
    }
}