class Solution {
    public int maxSubstrings(String word) {
        int n=word.length(),cnt=0;
        int[] fre = new int[26];
        Arrays.fill(fre,-1);
        for(int i=0;i<n;i++){
            int ch=word.charAt(i)-'a';
            if(fre[ch] == -1) fre[ch]=i;
            else if(i-fre[ch]+1 >= 4){
                cnt++;
                Arrays.fill(fre,-1);
            }
        }
        return cnt;
    }
}