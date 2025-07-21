class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length,val=0,ans=0;
        int[] arr=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i]==0) val-=1;
            else val+=1;
            arr[i]=val;
            if(val==0) ans=Math.max(ans,i+1);
            int index = map.getOrDefault(val,-1);
            if(index==-1) map.put(val,i);
            else ans=Math.max(ans,i-index);
        }
        return ans;
    }
}