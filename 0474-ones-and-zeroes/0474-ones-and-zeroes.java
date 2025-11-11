class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        int[][] fre = new int[size][2];
        for(int i=0;i<size;i++) fre[i] = getFrequency(strs[i].toCharArray());
        return helper(fre,m,n,size-1,new Integer[size][m+1][n+1]);
    }

    public int helper(int[][] fre,int m,int n,int i,Integer[][][] dp){
        if(i == -1) return 0;
        if(dp[i][m][n] != null) return dp[i][m][n];
        int notPick = helper(fre,m,n,i-1,dp);
        int pick = 0;
        if(m-fre[i][0] >= 0 && n-fre[i][1] >= 0) pick = 1+helper(fre,m-fre[i][0],n-fre[i][1],i-1,dp);
        return dp[i][m][n] = Math.max(pick,notPick);
    }

    public int[] getFrequency(char[] ch){
        int ones = 0, zeros = 0;
        for(char c : ch){
            if(c == '0') zeros++;
            else ones++;
        }
        return new int[]{zeros,ones};
    }
}