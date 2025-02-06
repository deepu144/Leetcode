class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length,res=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int product=nums[i]*nums[j];
                map.put(product,map.getOrDefault(product,0)+1);
            }
        }
        for(int key : map.keySet()){
            int val=map.get(key);
            if(val>=2){
                val--;
                res+=(8*((val*(val+1))/2));
            }
        }
        return res;
    }
}