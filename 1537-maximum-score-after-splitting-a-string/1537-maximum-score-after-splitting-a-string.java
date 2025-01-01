class Solution {
    public int maxScore(String s) {
        int zeros=0,ones=0,n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0') zeros++;
            else ones++;
        }
        int leftZero=0,leftOne=0,max=-1;
        for(int i=0;i<n-1;i++){
            char ch=s.charAt(i);
            if(ch=='0') leftZero++;
            else leftOne++;
            max=Math.max(max,leftZero+ones-leftOne);
        }
        return max;
    }
}