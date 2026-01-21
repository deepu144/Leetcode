class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            int val = nums.get(i);
            if(val == 2) ans[i] = -1;
            else{
                int min = (int)(1e9);
                for(int j=0;j<16;j++){
                    int newNum = val & ~(1<<j);
                    if((newNum | (newNum+1)) == val){
                        min = Math.min(min,newNum);
                    }
                }
                ans[i] = min;
            }
        }
        return ans;
    }
}