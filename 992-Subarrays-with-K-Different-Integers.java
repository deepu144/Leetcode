class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return result(nums,k)-result(nums,k-1);
    }
    public int result(int[] nums , int k){
        Map<Integer,Integer> map = new HashMap<>();
        int l=0,r=0,n=nums.length,count=0;
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}