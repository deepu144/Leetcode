class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,int[]> map=new HashMap<>();
        int n=nums.length,max=-1;
        for(int i=0;i<n;i++){
            int sumOfDigits=sumOfDigits(nums[i]);
            if(map.containsKey(sumOfDigits)){
                int[] p=map.get(sumOfDigits);
                if(p[0]<=nums[i]){
                    p[1]=p[0];
                    p[0]=nums[i];
                }else if(p[1]==-1 || p[1]<nums[i]) p[1]=nums[i];
            }else{
                int[] p=new int[]{-1,-1};
                p[0]=nums[i];
                map.put(sumOfDigits,p);
            }
        }
        for(int key : map.keySet()){
            int[] p=map.get(key);
            int sum=0;
            if(p[0]!=-1 && p[1]!=-1){
                sum=p[0]+p[1];
                max=Math.max(max,sum);
            }
        }
        return max;
    }
    public int sumOfDigits(int num){
        int sum=0;
        while(num>0){
            sum+=(num%10);
            num/=10;
        }
        return sum;
    }
}