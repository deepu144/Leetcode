class Solution {
    public String longestPalindrome(String s){
        int n=s.length(),max=-1,st=-1,e=-1;
        boolean[][] palindrome = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if((s.charAt(i)==s.charAt(j)) && (i-j<2 || palindrome[j+1][i-1])){
                    palindrome[j][i]=true;
                    if(max<(i-j+1)){
                        max=i-j+1;
                        st=j;
                        e=i+1;
                    }
                }
            }
        }
        return s.substring(st,e);
    }
}