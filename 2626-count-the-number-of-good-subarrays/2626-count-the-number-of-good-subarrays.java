class Solution {
    public long countGood(int[] nums, int k) {
        long count=0L;
        int left=0,right=0,n=nums.length,currPairs=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(right<n){
            int val=nums[right],fre=map.getOrDefault(val,0);
            if(fre!=0) currPairs+=fre;
            map.put(val,fre+1);
            while(left<right && currPairs>=k){
                val=nums[left];
                fre=map.get(val);
                if(fre!=1) map.put(val,fre-1);
                else if(fre==1) map.remove(val);
                currPairs-=(fre-1);
                left++;
            }
            count+=left;
            right++;
        }
        return count;
    }
}