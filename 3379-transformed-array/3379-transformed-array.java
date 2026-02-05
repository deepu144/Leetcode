class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            int val = nums[i];
            if(val == 0) result[i] = val;
            else if(val > 0) result[i] = nums[ (i + val) % n ];
            else result[i] = nums[ (((i + val) % n) + n) % n ];
        }
        return result;
    }
}