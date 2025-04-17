class Solution {
    final int HALF=720;
    final int FULL=1440;
    public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size(),min=FULL;
        for(int i=0;i<n;i++){
            int p=getTimeInMinutes(timePoints.get(i));
            for(int j=i+1;j<n;j++){
                int y=getTimeInMinutes(timePoints.get(j)),x=p;
                if(x==y) return 0;
                else if(y<x){
                    int t=x;
                    x=y;
                    y=t;
                }
                if(y-x > HALF) min=Math.min(min,x+(FULL-y));
                else min=Math.min(min,y-x);
            }
        }
        return min;
    }
    public int getTimeInMinutes(String s){
        String[] a=s.split(":");
        int x=Integer.parseInt(a[0])*60 + Integer.parseInt(a[1]);
        return x;
    }
}