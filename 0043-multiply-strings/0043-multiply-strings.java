class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length(), len = 0;
        if(n < m) return multiply(num2,num1);
        if(isNumberZero(num1,n) || isNumberZero(num2,m)) return "0";
        List<Integer>[] mat = new List[m];
        for(int i=0;i<m;i++) mat[i] = new ArrayList<>();
        for(int i=m-1;i>=0;i--){
            int curr = num2.charAt(i) - '0', remain = 0, j = m-i-1;
            while(j-->0) mat[i].add(0);
            for(j=n-1;j>=0;j--){
                int mul = ((num1.charAt(j) - '0') * curr) + remain;
                mat[i].add(mul%10);
                remain = mul / 10;
            }
            while(remain != 0){
                mat[i].add(remain%10);
                remain /= 10;
            }
            len = Math.max(len, mat[i].size());
        }
        StringBuilder sb = new StringBuilder();
        int remain = 0;
        for(int i=0;i<len;i++){
            int sum = remain;
            for(int j=0;j<m;j++) sum += (mat[j].size() > i) ? mat[j].get(i) : 0;
            sb.append(sum%10);
            remain = sum/10;
        }
        if(remain != 0) sb.append(remain);
        return sb.reverse().toString();
    }

    public boolean isNumberZero(String str,int n){
        for(int i=0;i<n;i++) if((str.charAt(i) - '0') != 0) return false;
        return true;
    }
}