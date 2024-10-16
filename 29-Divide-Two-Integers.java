class Solution {
    public int divide(int aa, int bb) {
        if (aa == Integer.MIN_VALUE && bb == -1) return Integer.MAX_VALUE;
        if(aa==bb) return 1;
        boolean sign=true;
        if((aa<0 && bb>0)||(aa>0 && bb<0)) sign=false;
        long a=Math.abs((long)aa);
        long b=Math.abs((long)bb);
        int ans=0;
        while(a>=b){
            int cnt=0;
            while(a>=(b<<cnt+1)) cnt++;
            ans+=(1<<cnt);
            a-=(b<<cnt);
        }
        return sign?ans:-ans;
    }
}