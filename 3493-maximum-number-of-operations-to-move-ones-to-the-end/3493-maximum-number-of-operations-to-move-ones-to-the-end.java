class Solution {
    public int maxOperations(String s) {
        int n = s.length(), ones = 0, ans = 0;
        boolean isPrevZero = true;
        for(int i=0;i<n-1;i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                if(isPrevZero) ans += ones;
                ones++;
                isPrevZero = false;
            }else isPrevZero = true;
        }
        if(s.charAt(n-1)=='0' || isPrevZero) ans += ones;
        return ans;
    }
}