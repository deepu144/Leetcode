class Solution {
    public int repeatedNTimes(int[] nums) {
        int a = nums[0], b = nums[1], n = nums.length;
        if(a == b || a == nums[n-1]) return a;
        boolean flag = true;
        for(int i=2;i<n;i++){
            int val = nums[i];
            if(a == val || b == val) return val;
            else if(flag) {
                a = val;
                flag = false;
            }else {
                b = val;
                flag = true;
            }
        }
        return -1;
    }
}