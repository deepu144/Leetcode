class Solution {
    public int numberOfSubarrays(int[] nums, int goal) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                nums[i]=0;
            }else{
                nums[i]=1;
            }
        }
        int a = 0;
        int b = 0;
        int len = nums.length;
        int count = 0;
        int ans = 0;
        while(a<len){
            if(b<len && nums[b]==1){
                count++;
                b++;
                if(count>goal){
                    while(nums[a]==0){
                        a++;
                    }
                    a++;
                    count--;
                }
                if(count==goal && a<b){
                    ans++;
                    int t = a;
                    while(t<b-1){
                        if(nums[t]==0){
                            ans++;
                            t++;
                        }else{
                            break;
                        }
                    }
                }
            }else if(b<len && nums[b]==0){
                b++;
                if(count==goal){
                    ans++;
                    int t = a;
                    while(t<b-1){
                        if(nums[t]==0){
                            ans++;
                            t++;
                        }else{
                            break;
                        }
                    }
                }
            }
            if(b>=len){
                a++;
            }
        }
        return ans;
    }
}