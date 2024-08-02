class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length,zero=0,one=0;
        int[] arr=new int[n*2];
        for(int i=0;i<n;i++){
            if(nums[i]==1) one++;
            arr[i]=arr[n+i]=nums[i];
        } 
        zero=n-one;
        if(one==n||one==0) return 0;
        int z=0,o=0,s=0,e=0,res=Integer.MAX_VALUE;
        while(e<n*2){
            if(arr[e]==0) z++;
            else o++;
            if(e-s+1==one){
                res=Math.min(res,z);
                if(arr[s]==0) z--;
                else o--;
                s++;
            }
            e++;
        }
        return res;
    }
}