class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int index=map.getOrDefault(nums[i],-1);
            if(index==-1) map.put(nums[i],i);
            else if(Math.abs(index-i)<=k) return true;
            else map.put(nums[i],i);
        }
        return false;
    }
}