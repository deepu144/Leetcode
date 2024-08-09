class Solution {
    public int minimumSwap(String s1, String s2) {
        int a=0,b=0,n=s1.length(),res=0;
        char[] ch1=s1.toCharArray();
        char[] ch2=s2.toCharArray();
        for(int i=0;i<n;i++){
            if(ch1[i]=='x' && ch2[i]=='y') a++;
            else if(ch1[i]=='y' && ch2[i]=='x') b++;
        }
        res+=a/2;
        res+=b/2;
        a%=2;
        b%=2;
        if(a!=b) return -1;
        if(a==1 && b==1) return res+2;
        return res;
    }
}