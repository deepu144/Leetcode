class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length(), left = 0, right = 0, res = 0;
        byte[] hash = new byte[26];
        for(right = 0; right < n ; right++) {
            int idx = s.charAt(right) - 'a';
            hash[idx]++;
            while(hash[idx] > 2) {
                hash[s.charAt(left) - 'a']--;
                left++;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}