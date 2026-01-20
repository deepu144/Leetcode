class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int val = nums.get(i);
            if(val == 2) ans[i] = -1;
            else{
                for(int j=1;j<val;j++){
                    if((j|(j+1)) == val){
                        ans[i] = j;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}