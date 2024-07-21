class Solution {
    public int maxOperations(String s) {
        int n=s.length(),ans=0,i=0,ones=0;
        while(i<n){
            int val = s.charAt(i)-'0';
            if(val==0){
                while(i<n && s.charAt(i)=='0'){
                    i++;
                }
                ans+=ones;
                if(i<n) ones++;
            }else{
                ones++;
            }
            i++;
        }
        return ans;
    }
}