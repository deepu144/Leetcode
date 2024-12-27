class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length,preMax=values[n-1]-(n-1),max=-1;
        for(int i=n-2;i>=0;i--){
            max=Math.max(max,values[i]+i+preMax);
            preMax=Math.max(preMax,values[i]-i);
        }
        return max;
    }
}