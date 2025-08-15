class Solution {
    public String largestGoodInteger(String num) {
        int n=num.length(),i=0,max=-1;
        while(i<n){
            int cnt=1;
            char ch=num.charAt(i);
            while(i+1<n && ch==num.charAt(i+1)){
                i++;
                cnt++;
            }
            if(cnt>=3) max=Math.max(max,ch-'0');
            i++;
        }
        if(max==-1) return "";
        return max+""+max+""+max;
    }
}