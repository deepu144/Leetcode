
class Solution {
    public String minWindow(String s, String t) {
        int[] thash = new int[128];
        int[] shash = new int[128];
        for (char c : t.toCharArray()) {
            thash[c]++;
        }
        int l = 0, r = 0;
        int required = t.length();
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (thash[c] > 0) {
                shash[c]++;
                if (shash[c] <= thash[c]) {
                    required--;
                }
            }
            while (required == 0) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    start = l;
                }
                char leftChar = s.charAt(l);
                if (thash[leftChar] > 0) {
                    shash[leftChar]--;
                    if(shash[leftChar] < thash[leftChar]) {
                        required++;
                    }
                }
                l++;
            }
            r++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
