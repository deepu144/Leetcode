class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        for(int sw : students) cnt[sw]++;
        for(int sw : sandwiches){
            if(cnt[sw] == 0) return cnt[0] + cnt[1];
            cnt[sw]--;
        }
        return 0;
    }
}