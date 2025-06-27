class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length,i=0,j=0;
        while(i<n && j<n){
            if(nums[i]!=key) i++;
            else if(j < i-k) j++;
            else if(j <= i+k) res.add(j++);
            else i++; 
        }
        return res;
    }
}