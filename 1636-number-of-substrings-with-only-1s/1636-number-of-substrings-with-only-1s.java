class Solution {
    final static int MOD = (int)(1e9+7);
    public int numSub(String s) {
        int n = s.length(), ones = 0, ans = 0;
        for(int i = 0; i < n ; i++){
            if(s.charAt(i) == '1') ones++;
            else{
                long temp = ((1L * ones * (ones+1))/2) % MOD;
                ans += (int)temp;
                ones = 0;
            }
        }
        long temp = ((1L * ones * (ones+1))/2) % MOD;
        ans += (int)temp;
        return ans;
    }
}