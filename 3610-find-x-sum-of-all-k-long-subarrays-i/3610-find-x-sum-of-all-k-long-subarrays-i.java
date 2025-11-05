class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer,Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>((a,b)->{
            int z = map.getOrDefault(a,-1);
            int y = map.getOrDefault(b,-1);
            if(z != y) return y-z;
            return b-a;
        });
        int n = nums.length,j=0, m = n-k+1;
        int[] res = new int[m];
        while(j<k){
            int fre = map.getOrDefault(nums[j],-1);
            if(fre==-1){
                map.put(nums[j],1);
                set.add(nums[j]);
            }else{
                set.remove(nums[j]);
                map.put(nums[j],fre+1);
                set.add(nums[j]);
            }
            j++;
        }
        res[0] = getTopSum(x,set,map);
        while(j<n){
            int prev = nums[j-k];
            int prevFre = map.get(prev);
            if(prevFre-1 == 0){
                set.remove(prev);
                map.remove(prev);
            }else{
                set.remove(prev);
                map.put(prev,prevFre-1);
                set.add(prev);
            }

            int fre = map.getOrDefault(nums[j],-1);
            if(fre==-1){
                map.put(nums[j],1);
                set.add(nums[j]);
            }else{
                set.remove(nums[j]);
                map.put(nums[j],fre+1);
                set.add(nums[j]);
            }
            j++;
            res[j-k] = getTopSum(x,set,map);
        }
        return res;
        
    }
    public int getTopSum(int x,TreeSet<Integer> set,Map<Integer,Integer> map){
        int sum=0;
        for(int val : set){
            sum+=(val*map.get(val));
            x--;
            if(x==0) return sum;
        }
        return sum;
    }
}