class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] ch=s.toCharArray();
        int n=ch.length,ones=0;
        for(int i=0;i<n;i++) if(ch[i]=='1') ones++;
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=ones-1;i++) sb.append('1');
        for(int i=0;i<n-ones;i++) sb.append('0');
        sb.append('1');
        return sb.toString();
    }
}