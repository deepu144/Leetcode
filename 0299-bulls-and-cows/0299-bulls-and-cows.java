class Solution {
    public String getHint(String secret, String guess) {
        int[] cnt = new int[10];
        int bull = 0, cow = 0, n = secret.length();
        boolean[] isBull = new boolean[n];
        for(int i = 0; i < n; i++) {
            char ch = guess.charAt(i);
            if(ch == secret.charAt(i)) {
                isBull[i] = true;
                bull++;
            }else cnt[ch - '0']++;
        }
        for(int i = 0; i < n; i++) {
            char ch = secret.charAt(i);
            if(!isBull[i] && cnt[ch - '0'] > 0) {
                cow++;
                cnt[ch - '0']--;
            }
        }
        return bull + "A" + cow + "B";
    }
}