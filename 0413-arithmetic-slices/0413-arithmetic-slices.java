class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length,j=0,prev=-1,cnt=1,ans=0;
        if(n==1) return 0;
        int[] arr=new int[n-1];
        List<Integer> li=new ArrayList<>();
        for(int i=1;i<n;i++) arr[j++]=nums[i]-nums[i-1];
        prev=arr[0];
        for(int i=1;i<n-1;i++){
            if(prev==arr[i]) cnt++;
            else{
                li.add(cnt);
                cnt=1;
                prev=arr[i];
            }
        }
        li.add(cnt);
        for(int val : li) if(val > 1) ans += (val*(val-1))/2;
        return ans;
    }
}