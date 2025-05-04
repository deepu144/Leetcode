class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n=dominoes.length,res=0;
        int[][] dp = new int[10][10];
        for(int[] a : dominoes) dp[a[0]][a[1]]++;
        for(int i=1;i<10;i++){
            for(int j=i;j<10;j++){
                int cnt=dp[i][j];
                if(i!=j) cnt+=dp[j][i];
                res += (cnt*(cnt-1))/2;
            }
        }
        return res;
    }
}