class Solution {
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=-1;
        boolean[][] palindrome = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if((s.charAt(i)==s.charAt(j)) && (i-j<2 || palindrome[j+1][i-1])) palindrome[j][i]=true;
            }
        }
        for(int i=n-1;i>=0;i--){
            int count=0,min=(int)(1e9);
            for(int j=i;j<n;j++){
                if(palindrome[i][j]){
                    count = 1 + dp[j+1];
                    min=Math.min(min,count);
                }
            }
            dp[i]=min;
        }
        return dp[0];
    }
}