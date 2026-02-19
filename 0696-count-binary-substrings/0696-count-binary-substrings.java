class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length(), i = 1, cnt = 1;
        char prev = s.charAt(0);
        List<Integer> li = new ArrayList<>();
        while(i < n) {
            char ch = s.charAt(i);
            if(prev == ch) cnt++;
            else {
                prev = ch;
                li.add(cnt);
                cnt = 1;
            }
            i++;
        }
        li.add(cnt);
        cnt = 0;
        n = li.size();
        for(i = 1; i < n; i++) {
            cnt += Math.min(li.get(i-1), li.get(i));
        }
        return cnt;
    }
}