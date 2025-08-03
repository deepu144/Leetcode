class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length,j=n-1,cnt=0,min=n+1;
        Arrays.sort(nums);
        Set<Integer> set=new HashSet<>();
        for(int val : nums) set.add(val);
        for(int i=0;i<n;i++){
            long mul = 1L*k*nums[i];
            int right=0,left=0;

            if(set.contains(nums[i])) right = countGreaterThan(nums,n,mul+1);
            else right = countGreaterThan(nums,n,mul);

            left = countLessThan(nums,n,nums[i]);
            min=Math.min(min,right+left);
        }
        return min;
    }
    public int countLessThan(int[] nums,int n,long k){
        int left = 0,right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < k) left = mid + 1;
            else right = mid; 
        }
        return left;
    }
    public int countGreaterThan(int[] nums,int n,long k){
        int left = 0,right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < k) left = mid + 1;
            else right = mid;
        }
        return n-left;
    }
}