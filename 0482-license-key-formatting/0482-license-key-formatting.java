class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int n = s.length(),cnt=0;
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch == '-') continue;
            sb.append(Character.toUpperCase(ch));
            if(++cnt == k){
                cnt = 0;
                sb.append('-');
            }
        }
        n = sb.length();
        if(n>0 && sb.charAt(n-1)=='-') sb.deleteCharAt(n-1);
        return sb.reverse().toString();
    }
}