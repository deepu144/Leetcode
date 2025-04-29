class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length,left=0,right=0,cnt=0,curr=0,ans=0;
        int[] fre=new int[2001];
        for(int val : nums) fre[val]++;
        for(int i=1;i<2001;i++) if(fre[i]!=0) cnt++;
        Arrays.fill(fre,0);
        while(right<n){
            if(fre[nums[right]]==0) curr++;
            fre[nums[right]]++;
            while(curr==cnt){
                ans+=(n-right);
                fre[nums[left]]--;
                if(fre[nums[left]]==0) curr--;
                left++;
            }
            right++;
        }
        return ans;
    }
}