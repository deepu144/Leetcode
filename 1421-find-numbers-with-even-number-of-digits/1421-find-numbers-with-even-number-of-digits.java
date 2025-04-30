class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int num : nums){
            int a=(int)Math.log10(num);
            if(a%2==1) count++;
        }
        return count;
    }
}