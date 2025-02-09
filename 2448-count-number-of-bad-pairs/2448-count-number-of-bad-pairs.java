class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Long> map=new HashMap<>();
        long count=0,res=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int val=nums[i]-i;
            long numCount=map.getOrDefault(val,0L)+1L;
            map.put(val,numCount);
            count++;
            res+=count-numCount;
        }
        return res;
    }
}