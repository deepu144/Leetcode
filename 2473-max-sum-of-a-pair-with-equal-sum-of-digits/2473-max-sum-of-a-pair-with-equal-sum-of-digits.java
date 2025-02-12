class Solution {
    public int maximumSum(int[] nums) {
        int[] map=new int[82];
        int n=nums.length,max=-1;
        for(int i=0;i<n;i++){
            int sumOfDigits=sumOfDigits(nums[i]),a=map[sumOfDigits];
            if(a!=0) max=Math.max(max,a+nums[i]);
            map[sumOfDigits]=Math.max(a,nums[i]);
        }
        return max;
    }
    public int sumOfDigits(int num){
        int sum=0;
        while(num>0){
            sum+=(num%10);
            num/=10;
        }
        return sum;
    }
}