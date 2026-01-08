class Solution {
    public String maskPII(String s) {
        String[] arr = s.split("@");
        if(arr.length == 1) return maskPhoneNumber(s);
        return maskEmail(arr);
    }
    public String maskEmail(String[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(arr[0].charAt(0)));
        sb.append("*****");
        sb.append(Character.toLowerCase(arr[0].charAt(arr[0].length()-1)));
        sb.append('@');
        String[] s = arr[1].split("[.]");
        sb.append(s[0].toLowerCase());
        sb.append('.');
        sb.append(s[1].toLowerCase());
        return sb.toString();
    }
    public String maskPhoneNumber(String s){
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) sb.append(ch);
        }
        n = sb.length();
        String mask = "***-***-";
        if(n == 10) return mask+sb.substring(6,n);
        else if(n == 11) return "+*-"+mask+sb.substring(7,n);
        else if(n == 12) return "+**-"+mask+sb.substring(8,n);
        return "+***-"+mask+sb.substring(9,n);
    }
}