class Solution {
    public String fractionAddition(String expr) {
        int n = expr.length();
        int num = 0;
        int den = 1;
        int i = 0;

        while (i < n) {
            int currNum = 0;
            int currDen = 0;

            boolean isNeg = (expr.charAt(i) == '-');
            if (expr.charAt(i) == '+' || expr.charAt(i) == '-') i++;

            while (i < n && Character.isDigit(expr.charAt(i))) {
                int val = expr.charAt(i) - '0';
                currNum = (currNum * 10) + val;
                i++;
            }
            i++;
            if (isNeg) currNum *= -1;

            while (i < n && Character.isDigit(expr.charAt(i))) {
                int val = expr.charAt(i) - '0';
                currDen = (currDen * 10) + val;
                i++;
            }

            num = num * currDen + den * currNum;
            den = den * currDen;
        }

        int gcd = gcd(Math.abs(num), den);
        num /= gcd;
        den /= gcd;

        return num + \/\ + den;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}