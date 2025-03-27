class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size(),max=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val : nums) map.put(val,map.getOrDefault(val,0)+1);
        for(int key : map.keySet()){
            int val=map.get(key);
            if(val>n/2){
                max=key;
                break;
            }
        }
        int[] prefix=new int[n];
        prefix[0]=(nums.getFirst()==max)?1:0;
        for(int i=1;i<n;i++){
            prefix[i]+=prefix[i-1];
            if(nums.get(i)==max) prefix[i]++;
        }
        for(int i=0;i<n;i++) if(2*prefix[i]>(i+1) && 2*(prefix[n-1]-prefix[i])>(n-i-1)) return i;
        return -1;
    }
}