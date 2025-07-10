class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n=startTime.length,m=0,ans=0,prefix=0;
        List<Integer> gaps=new ArrayList<>();
        gaps.add(startTime[0]);
        for(int i=0;i<n-1;i++) gaps.add(startTime[i+1]-endTime[i]);
        gaps.add(eventTime-endTime[n-1]);
        m=gaps.size();
        int[] suffix = new int[m+2];
        suffix[m-1]=gaps.getLast();
        for(int i=m-2;i>=0;i--) suffix[i]=Math.max(suffix[i+1],gaps.get(i));
        for(int i=0;i<n;i++){
            ans = Math.max(ans,gaps.get(i)+gaps.get(i+1));
            int duration = endTime[i]-startTime[i];
            if(prefix >= duration || suffix[i+2] >= duration) ans = Math.max(ans,gaps.get(i)+gaps.get(i+1)+duration);
            prefix = Math.max(prefix,gaps.get(i));
        }
        return ans;
    }
}