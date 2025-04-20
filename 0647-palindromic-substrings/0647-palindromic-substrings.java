class Solution {
    public int countSubstrings(String s) {
        int n=s.length(),count=0;
        boolean[][] palindrome = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if((s.charAt(i)==s.charAt(j)) && (i-j<2 || palindrome[j+1][i-1])){
                    palindrome[j][i]=true;
                    count++;
                }
            }
        }
        return count;
    }
}