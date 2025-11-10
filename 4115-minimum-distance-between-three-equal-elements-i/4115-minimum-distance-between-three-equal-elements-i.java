class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length, ans = (int)(1e9);
        int[] next = new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int idx = map.getOrDefault(nums[i],-1);
            if(idx == -1) map.put(nums[i],i);
            else{
                next[idx]=i;
                map.put(nums[i],i);
            }
        }
        for(int i=0;i<n;i++){
            int j = next[i];
            int k = next[j];
            if(j == 0 || k == 0) continue;
            ans = Math.min(ans,(2*k)-(2*i));
        }
        if(ans == (int)(1e9)) return -1;
        return ans;
    }
}