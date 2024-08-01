class Solution {
    public int appendCharacters(String s, String t) {
        int a=0,b=0,sn=s.length(),tn=t.length(),res=tn;
        char[] ch1=s.toCharArray();
        char[] ch2=t.toCharArray();
        while(a<sn && b<tn){
            if(ch1[a]==ch2[b]){
                b++;
                res--;
            }
            a++;
        }
        return res;
    }
}