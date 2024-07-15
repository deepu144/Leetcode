class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] hash = new int[26];
        int l=0,r=0,max=0,hfre=0;
        char[] ch = s.toCharArray();
        while(r<n){
            int c = ch[r] - 'A';
            hash[c]++;
            hfre = Math.max(hfre, hash[c]);
            if (r - l + 1 - hfre > k) {
                hash[ch[l] - 'A']--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}