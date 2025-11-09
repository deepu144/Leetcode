class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        Map<Integer,Integer> map = new HashMap<>();
        TreeSet<Integer> topX = new TreeSet<>((a,b)->{
            int y = map.get(a);
            int z = map.get(b);
            if(y != z) return y-z;
            return a-b;
        });
        TreeSet<Integer> nextX = new TreeSet<>((a,b)->{
            int y = map.get(a);
            int z = map.get(b);
            if(y != z) return z-y;
            return b-a;
        });
        int j=0, n = nums.length, m = n-k+1;
        long[] res = new long[m];
        long sum = 0L;
        while(j<n){
            if(j>=k){
                int pre = nums[j-k];
                int preFre = map.get(pre);
                if(preFre-1 == 0){
                    if(topX.contains(pre)){
                        topX.remove(pre);
                        sum -= pre;
                        if(!nextX.isEmpty()){
                            int temp = nextX.getFirst();
                            topX.add(temp);
                            nextX.remove(temp);
                            sum += (1L * map.get(temp) * temp);
                        }
                    }else nextX.remove(pre);
                    map.remove(pre);
                }else{
                    if(topX.contains(pre)){
                        topX.remove(pre);
                        map.put(pre,preFre-1);
                        sum -= pre;
                        topX.add(pre);
                        if(!nextX.isEmpty()){
                            int temp = topX.getFirst();
                            int t = nextX.getFirst();
                            if((map.get(t) > map.get(temp)) || (map.get(t) == map.get(temp) && t > temp)){
                                topX.remove(temp);
                                sum -= (1L * temp * map.get(temp));
                                nextX.remove(t);
                                topX.add(t);
                                nextX.add(temp);
                                sum += (1L * t * map.get(t));
                            }
                        }
                    }else{
                        nextX.remove(pre);
                        map.put(pre,preFre-1);
                        nextX.add(pre);
                    }
                }
            }
            int fre = map.getOrDefault(nums[j],-1);
            if(fre == -1){
                map.put(nums[j],1);
                if(topX.size() < x){
                    topX.add(nums[j]);
                    sum+=nums[j];
                }
                else{
                    int temp = topX.getFirst();
                    if((map.get(temp) < map.get(nums[j])) || (map.get(temp) == map.get(nums[j]) && temp < nums[j])){
                        topX.remove(temp);
                        topX.add(nums[j]);
                        sum += ( (map.get(nums[j]) * nums[j]) - (map.get(temp) * temp) );
                        nextX.add(temp);
                    }else nextX.add(nums[j]);
                }
            }else{

                if(topX.contains(nums[j])){
                    topX.remove(nums[j]);
                    map.put(nums[j],fre+1);
                    topX.add(nums[j]);
                    sum += nums[j];
                }else{
                    nextX.remove(nums[j]);
                    map.put(nums[j],fre+1);
                    nextX.add(nums[j]);
                    int temp = topX.getFirst();
                    int t = nextX.getFirst();
                    if((map.get(t) > map.get(temp)) || (map.get(t) == map.get(temp) && t > temp)){
                        topX.remove(temp);
                        sum -= (1L * temp * map.get(temp));
                        nextX.remove(t);
                        topX.add(t);
                        nextX.add(temp);
                        sum += (1L * t * map.get(t));
                    }
                }
            }
            j++;
            if(j-k>=0) res[j-k] = sum;
        }
        return res;
    }
        
}