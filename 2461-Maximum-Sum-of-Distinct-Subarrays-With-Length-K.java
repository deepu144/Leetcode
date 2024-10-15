class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length,l=0,r=0;
        long sum=0,max=0;
        while(r<n){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            sum+=arr[r];
            if((r-l+1)>k){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0) map.remove(arr[l]);
                sum-=arr[l];
                l++;
            }
            if((r-l+1)==k && map.size()==k) max=Math.max(max,sum);
            r++;
        }
        return max;
    }
}