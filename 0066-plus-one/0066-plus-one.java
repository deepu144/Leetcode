class Solution {
    public int[] plusOne(int[] digits) {
        int cnt = 0, n = digits.length;
        for(int digit : digits) 
            if(digit == 9) cnt++;
        if(cnt == n) {
            int[] res = new int[n+1];
            res[0] = 1;
            return res;
        }
        return plusOne(digits, n);
    }

    public int[] plusOne(int[] digits, int n) {
        int carry = 0;
        digits[n-1]++;
        for(int i = n-1; i >= 0 ; i--) {
            digits[i] += carry;
            if(digits[i] >= 10) {
                carry = digits[i]/10;
                digits[i] = digits[i] % 10;
            } else carry = 0;
        }
        return digits;
    }

}