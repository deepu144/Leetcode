class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length(),m=(int)Math.ceil(n/(k*1.0)),j=0;
        String[] res=new String[m];
        for(int i=0;i<n;i+=k){
            if(i+k<=n) res[j++]=s.substring(i,i+k);
            else{
                res[j]=s.substring(i,n);
                int times = k - res[j].length();
                res[j] += (fill+"").repeat(times);
            }
        }
        return res;
    }
}