class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer,Boolean> map=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        int n = nums.length;
        for(int val : nums) map.put(val,false);
        for(int i=1;i<=n;i++) if(map.getOrDefault(i,true)) ans.add(i);
        return ans;
    }
}