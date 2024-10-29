class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb=new StringBuilder("0");
        while(n-->0){
            String s=invertAndReverse(sb.toString());
            sb.append('1');
            sb.append(s);
            if(sb.length()>=k) return sb.charAt(k-1);
        }
        return sb.charAt(k-1);
    }
    public String invertAndReverse(String s){
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='0') ch[i]='1';
            else ch[i]='0';
        }
        StringBuilder sb=new StringBuilder();
        for(int i=ch.length-1;i>=0;i--) sb.append(ch[i]);
        return sb.toString();
    }
}