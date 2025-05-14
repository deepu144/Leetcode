class Solution {
    public static final int MOD=(int)(1e9+7);
    public int lengthAfterTransformations(String s, int t) {
        int[] fre=new int[26];
        int n=s.length(),cnt=0;
        for(int i=0;i<n;i++) fre[s.charAt(i)-'a']++;
        for(int i=0;i<t;i++){
            int[] temp=new int[26];
            for(int j=0;j<25;j++) temp[j+1]=fre[j];
            if(fre[25]!=0){
                temp[0]=(temp[0]+fre[25])%MOD;
                temp[1]=(temp[1]+fre[25])%MOD;
            }
            fre=temp;
        }
        for(int i=0;i<26;i++) cnt=(cnt+fre[i])%MOD;
        return cnt;
    }
}