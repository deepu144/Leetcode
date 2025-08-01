class Solution {
    public String breakPalindrome(String palindrome) {
        int n=palindrome.length(),i=0;
        if(n==1) return "";
        StringBuilder sb=new StringBuilder();
        while(i<n){
            char ch=palindrome.charAt(i);
            if(ch > 'a'){
                sb.append('a');
                sb.append(palindrome.substring(i+1));
                if(!isPalindrome(sb,n)) return sb.toString();
                return palindrome.substring(0,n-1)+"b";
            }
            sb.append('a');
            i++;
        }
        return palindrome.substring(0,n-1)+"b";
    }
    public boolean isPalindrome(StringBuilder sb,int n){
        int i=0,j=n-1;
        while(i<j){
            if(sb.charAt(i)!=sb.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}