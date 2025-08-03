class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length,m=waterStartTime.length,min=(int)(1e9);
        for(int i=0;i<n;i++){
            int t = landStartTime[i]+landDuration[i];
            for(int j=0;j<m;j++){
                int t2 = t + waterDuration[j];
                if(waterStartTime[j]>t)  t2+= (waterStartTime[j]-t);
                min=Math.min(min,t2);
            }
        }
        for(int i=0;i<m;i++){
            int t = waterStartTime[i]+waterDuration[i];
            for(int j=0;j<n;j++){
                int t2 = t + landDuration[j];
                if(landStartTime[j]>t)  t2+= (landStartTime[j]-t);
                min=Math.min(min,t2);
            }
        }
        return min;
    }
}