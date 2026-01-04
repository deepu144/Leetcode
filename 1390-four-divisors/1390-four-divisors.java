class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int val : nums) sum += check(val);
        return sum;
    }
    public int check(int val){
        int sqrt = (int)Math.sqrt(val), sum = 0;
        Set<Integer> set=new HashSet<>();
        for(int i=1;i<=sqrt;i++){
            if(val%i==0){
                set.add(i);
                set.add(val/i);
                sum+=(i+(val/i));
            }
            if(set.size()>4) return 0;
        }
        return set.size() == 4? sum : 0;
    }
}