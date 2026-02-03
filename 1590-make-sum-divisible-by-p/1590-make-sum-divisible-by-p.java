class Solution {
    public int minSubarray(int[] nums, int p) {
        Map<Long,Integer> map = new HashMap<>();
        long sum = 0L;
        int n = nums.length, min = n;
        for(int val : nums) sum += val;
        long rem = sum % p;
        if(rem == 0) return 0;
        sum = 0L;
        map.put(0L,-1);
        for(int i=0;i<n;i++){
            sum = (sum + nums[i]) % p;
            long cmp = (sum - rem + p) % p;
            if(map.containsKey(cmp)) min = Math.min(min, i - map.get(cmp));
            map.put(sum, i);
        }
        if(min == n) return -1;
        return min;
    }
}