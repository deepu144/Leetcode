class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length,i=0;
        List<Integer> ans = new ArrayList<>();
        List<Long> temp = new LinkedList<>();
        while(i<n){
            long mul = nums[i];
            while(i+1<n){
                long gcd = gcd(mul,nums[i+1]);
                if(gcd == 1) break;
                mul = (mul * nums[i+1])/gcd;
                i++;
            }
            if(!temp.isEmpty()){
                while(!temp.isEmpty()){
                    long prev = temp.getLast();
                    long gcd = gcd(prev,mul);
                    if(gcd == 1) break;
                    mul = (mul * prev) / gcd;
                    temp.removeLast();
                }
            }
            temp.addLast(mul);
            i++;
        }
        for(long val : temp) ans.add((int)val);
        return ans;
    }
    public long gcd(long a, long b) {
        return b==0 ? a : gcd(b, a % b);
    }
}