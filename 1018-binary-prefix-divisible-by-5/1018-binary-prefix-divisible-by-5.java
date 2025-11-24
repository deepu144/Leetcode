class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int num = 0;
        List<Boolean> ans = new ArrayList<>();
        for(int bit : nums){
            num <<= 1;
            num |= bit;
            num %= 5;
            ans.add(num==0);
        }
        return ans;
    }
}