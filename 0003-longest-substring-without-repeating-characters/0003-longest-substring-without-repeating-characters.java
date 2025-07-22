class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length(),l=0,max=0;
        boolean[] hash=new boolean[256];
        for(int r=0;r<n;r++){
            int ch = s.charAt(r);
            while(hash[ch]) hash[s.charAt(l++)]=false;
            hash[ch]=true;
            max=Math.max(max,r-l+1);
        }
        return max;
    }
}