class Solution {
    public int findLHS(int[] nums) {
        int n=nums.length,max=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int val : nums) map.put(val,map.getOrDefault(val,0)+1);
        for(int key : map.keySet()){
            if(map.containsKey(key+1)) max=Math.max(max,map.get(key)+map.get(key+1));
        }
        return max;
    }
}