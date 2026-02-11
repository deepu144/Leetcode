class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length, prev = 0, k = 0, i = n - 1, cnt = 0;
        Arrays.sort(nums);
        prev = nums[i];
        Map<Integer,Boolean> map = new HashMap<>();
        for(int val : nums) map.put(val, true);
        k = map.size();
        while(k > 1){
            while(i >= 0 && nums[i] == prev) i--;
            cnt += (n - i - 1);
            prev = nums[i];
            k--;
        }
        return cnt;
    }
}