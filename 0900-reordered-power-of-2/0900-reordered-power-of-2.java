class Solution {
    public boolean reorderedPowerOf2(int n) {
        int size = (int)(Math.log10(n)+1);
        int[] nums = new int[size];
        for(int i=size-1;i>=0;i--){
            int digit = n%10;
            nums[i]=digit;
            n/=10;
        }
        Arrays.sort(nums);
        return helper(nums,size,new boolean[size],0L,0);
    }
    public boolean helper(int[] nums,int n,boolean[] used,long curr,int cnt){
        if(cnt==n) return (curr&(curr-1))==0 && ((int)(Math.log10(curr)+1))==n;
        for(int i=0;i<n;i++){
            if(used[i]) continue;
            used[i]=true;
            if(helper(nums,n,used,(curr*10L)+nums[i],cnt+1)) return true;
            used[i]=false;
        }
        return false;
    }
}