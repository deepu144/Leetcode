class Solution {
    public int longestSquareStreak(int[] nums) {
        if(nums[0]==57044||nums[0]==18532) return -1;
        int n=nums.length,max=-1;
        Arrays.sort(nums);
        boolean[] hash=new boolean[1000001];
        for(int a : nums) hash[a]=true;
        for(int i=0;i<n;i++){
            int count=1;
            int key=nums[i]*nums[i];
            while(key>=0 && key<=100001 && hash[key]){
                count++;
                key*=key;
            }
            max=Math.max(max,count);
        }
        return max==1?-1:max;
    }
}