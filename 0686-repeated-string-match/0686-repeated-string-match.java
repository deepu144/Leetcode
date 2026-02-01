class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n = b.length(), m = a.length(), cnt = 0, stIndex = -1, endIndex = -1;
        if(a.contains(b)) return 1;
        if((a+a).contains(b)) return 2;
        String s = a+"#"+b;
        n = s.length();
        int[] lps = constructLPS(s,n);
        for(int i=m+1;i<n;i++){
            if(lps[i] == m){
                stIndex = i - m + 1;
                endIndex = i;
                break;
            }
        }
        if(stIndex == endIndex && stIndex == -1) return stIndex;
        for(int i=endIndex;i<n;i+=m){
            if(lps[endIndex] == m){
                cnt++;
                endIndex=i;
            }
        }
        int temp = 0;
        for(int i = endIndex+1;i<n;i++){
            if(s.charAt(temp) == s.charAt(i)) temp++;
            else return -1;
        }
        if(temp != 0) cnt++;
        temp = m;
        for(int i = stIndex-1;i>m;i--){
            if(temp-1 < 0 || s.charAt(i) != s.charAt(temp-1)) return -1;
            temp--;
        }
        if(temp != m) cnt++;
        return cnt;
    }   
    public int[] constructLPS(String s,int n){
        int[] lps = new int[n];
        Arrays.fill(lps,0);
        for(int i=1;i<n;i++){
            int prev_idx = lps[i-1];

            while(prev_idx > 0 && s.charAt(i) != s.charAt(prev_idx)) prev_idx = lps[prev_idx-1];

            lps[i] = prev_idx + (s.charAt(i) == s.charAt(prev_idx) ? 1 : 0);
        }
        return lps;
    }
}