class Solution {
    public long minimumSteps(String s) {
        int n=s.length();
        long ones=0L,ans=0L;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0') ones++;
            else ans+=ones;
        }
        return ans;
    }
}