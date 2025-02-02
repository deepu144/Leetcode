class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> li=new ArrayList<>();
        li.add(startTime[0]);
        int n=startTime.length;
        for(int i=1;i<n;i++) li.add(startTime[i]-endTime[i-1]);
        li.add(eventTime-endTime[n-1]);
        int max=-1,sum=0;
        for(int i=0;i<li.size() && i<k+1;i++) sum+=li.get(i);
        max=sum;
        for(int i=k+1;i<li.size();i++){
            sum+=li.get(i);
            sum-=li.get(i-k-1);
            max=Math.max(max,sum);
        }
        return max;
    }
}