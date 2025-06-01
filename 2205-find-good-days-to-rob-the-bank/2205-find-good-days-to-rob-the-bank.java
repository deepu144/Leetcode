class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n=security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        List<Integer> ans=new ArrayList<>();
        int cnt=0;
        for(int i=1;i<n;i++){
            if(security[i-1] >= security[i]) cnt++;
            else cnt=0;
            left[i]=cnt;
        }
        cnt=0;
        for(int i=n-2;i>=0;i--){
            if(security[i+1] >= security[i]) cnt++;
            else cnt=0;
            right[i]=cnt;
        }
        for(int i=time;i<n-time;i++){
            if(left[i]>=time && right[i]>=time) ans.add(i);
        }
        return ans;
    }
}