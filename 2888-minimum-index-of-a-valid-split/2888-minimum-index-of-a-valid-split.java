class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size(),max=-1,fre=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val : nums) map.put(val,map.getOrDefault(val,0)+1);
        for(int key : map.keySet()){
            int val=map.get(key);
            if(val>n/2){
                max=key;
                fre=val;
                break;
            }
        }
        int curr=0;
        for(int i=0;i<n;i++){
            if(nums.get(i)==max) curr++;
            if(2*curr>(i+1) && 2*(fre-curr)>(n-i-1)) return i;
        }
        return -1;
    }
}