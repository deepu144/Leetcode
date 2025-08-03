class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length,m=waterStartTime.length,min1=(int)(1e9),min2=min1,ans1=min1,ans2=min1;
        for(int i=0;i<n;i++){
            min1 = Math.min(min1,landStartTime[i]+landDuration[i]);
        }
        for(int i=0;i<m;i++){
            ans1 = Math.min(ans1, Math.max(min1,waterStartTime[i]) + waterDuration[i] );
        }
        for(int i=0;i<m;i++){
            min2 = Math.min(min2,waterStartTime[i]+waterDuration[i]);
        }
        for(int i=0;i<n;i++){
            ans2 = Math.min(ans2, Math.max(min2,landStartTime[i]) + landDuration[i] );
        }
        return Math.min(ans1,ans2);
    }
}