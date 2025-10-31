class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n=nums.length,a=-1,b=a;
        boolean[] fre = new boolean[101];
        for(int val : nums){
            if(fre[val]){
                if(a==-1) a=val;
                else if(b==-1) b=val;
            }
            fre[val]=true;
        }
        return new int[]{a,b};
    }
}