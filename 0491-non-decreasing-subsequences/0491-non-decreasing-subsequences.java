class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans=new HashSet<>();
        int n=nums.length;
        subset(nums,n-1,101,new ArrayList<>(),ans);
        return new ArrayList<>(ans);
    }
    public void subset(int[] nums,int i,int pre,List<Integer> li,Set<List<Integer>> ans){
        if(i==-1){
            if(!li.isEmpty() && li.size()!=1) ans.add(new ArrayList<>(li));
            return;
        }
        subset(nums,i-1,pre,li,ans);
        if(pre>=nums[i]){
            li.add(0,nums[i]);
            subset(nums,i-1,nums[i],li,ans);
            li.removeFirst();
        }
    }
}