class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = nums[i];
        Arrays.sort(arr);
        for(int i=0;i<n;i++) map.putIfAbsent(arr[i],i);
        if(map.size() == 1) return new int[n];
        for(int i=0;i<n;i++) nums[i] = map.get(nums[i]);
        return nums;
    }
}