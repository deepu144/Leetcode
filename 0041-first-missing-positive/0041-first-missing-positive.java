class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer,Boolean> map=new HashMap<>();
        int idx = 1;
        for(int val : nums){
            while(map.containsKey(idx)) idx++;
            map.put(val,true);
        }
        while(map.containsKey(idx)) idx++;
        return idx;
    }
}