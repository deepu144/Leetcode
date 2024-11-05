class Solution {
    public int maxOperations(int[] nums, int k) {
        int n=nums.length,count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        for(int i=0;i<n;i++){
            int complement=k-nums[i];
            if(complement<0) continue;
            if(complement==nums[i]){
                int val=map.getOrDefault(nums[i],0);
                if(val>1){
                    count++;
                    map.put(nums[i],val-2);
                }
            }else if(map.containsKey(complement) && map.containsKey(nums[i])){
                int c=map.get(complement);
                int v=map.get(nums[i]);
                count++;
                if(c-1==0) map.remove(complement);
                else map.put(complement,c-1);
                if(v-1==0) map.remove(nums[i]);
                else map.put(nums[i],v-1);
            }
        }
        return count;
    }
}