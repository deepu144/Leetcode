class Solution {
    public int maxGoodNumber(int[] nums) {
        String b1=Integer.toString(nums[0],2);
        String b2=Integer.toString(nums[1],2);
        String b3=Integer.toString(nums[2],2);
        int max=-1;
        max=Math.max(max,Integer.parseInt(b1+b2+b3,2));
        max=Math.max(max,Integer.parseInt(b3+b2+b1,2));
        max=Math.max(max,Integer.parseInt(b2+b3+b1,2));
        max=Math.max(max,Integer.parseInt(b3+b2+b1,2));
        max=Math.max(max,Integer.parseInt(b1+b3+b2,2));
        max=Math.max(max,Integer.parseInt(b3+b1+b2,2));
        max=Math.max(max,Integer.parseInt(b2+b1+b3,2));
        return max;
    }
}