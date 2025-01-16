class Solution {
    public int singleNumber(int[] nums) {
        int[] bit=new int[32];
        for(int n : nums) for(int i=0;i<32;i++) if(((n>>i)&1)!=0) bit[i]++;
        int res=0;
        for(int i=31;i>=0;i--){
            res<<=1;
            int b=bit[i]%3;
            res|=b;
        }
        return res;
    }
}