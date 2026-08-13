class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        if(isZero(num1,m) || isZero(num2,n)) return "0";
        int row = n, col = 0, carry = 0;
        List<Integer>[] mat = new List[row];
        for(int i=0;i<row;i++) mat[i] = new ArrayList<>();
        for(int i = n-1; i>=0; i--) {
            for(int j = 0; j < n-i-1; j++) mat[n-i-1].add(0);
            carry = 0;
            int b = num2.charAt(i) - '0';
            for(int j = m-1; j>=0; j--) {
                int a = num1.charAt(j) - '0';
                int prod = a*b + carry;
                if(prod >= 10) {
                    carry = prod/10;
                    prod %= 10;
                } else carry = 0;
                mat[n-i-1].add(prod);
            }
            while(carry > 0) {
                mat[n-i-1].add(carry%10);
                carry/=10;
            }
        }
        for(int i=0;i<row;i++) col = Math.max(col,mat[i].size());
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < col ;j++) {
            int sum = carry;
            for(int i = 0; i < row; i++) {
                if(mat[i].size() > j) 
                    sum += mat[i].get(j);
            }
            if(sum >= 10) {
                carry = sum/10;
                sum %= 10;
            } else carry = 0;
            sb.append(sum);
        }
        if(carry != 0 ) sb.append(carry);
        return sb.reverse().toString();
    }
    public boolean isZero(String s, int n) {
        for(int i = 0; i<n ; i++) if(s.charAt(i) != '0') return false;
        return true;
    }
}