class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length, oddCount = 0, evenCount = 0, max = 0;
        int[] map = new int[100001];
        for(int val : nums) {
            map[val]++;
            if(map[val] > 1) continue;
            if((val & 1) == 0) evenCount++;
            else oddCount++;
        }
        int m = Math.min(oddCount,evenCount);
        for(int i=1 ;i <= m; i++) max = Math.max(max, getLongestBalanced(nums, n, i));
        return max;
    }
    public int getLongestBalanced(int[] nums, int n, int k){
        int oddCount = 0, evenCount = 0, right = 0, left = 0, max = 0;
        int[] map = new int[100001];
        while(right < n) {
            if(map[nums[right]] == 0) {
                if((nums[right] & 1) == 0) evenCount++;
                else oddCount++;
            }
            map[nums[right]]++;
            while((evenCount > k || oddCount > k) && left < right) {
                map[nums[left]]--;
                if(map[nums[left]] == 0) {
                    if((nums[left] & 1) == 0) evenCount--;
                    else oddCount--;
                }
                left++;
            }
            if(evenCount == oddCount && evenCount == k) max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}