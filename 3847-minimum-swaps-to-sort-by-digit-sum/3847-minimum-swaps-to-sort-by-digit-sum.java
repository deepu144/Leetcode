class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length,cnt=0;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++) arr[i]=new int[]{sumOfDigits(nums[i]),i};
        Arrays.sort(arr,(a,b)->{
            if(a[0] == b[0]) return nums[a[1]]-nums[b[1]];
            return a[0]-b[0];
        });
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) map.put(arr[i][1],i);
        for(int i=0;i<n;i++){
            int[] temp = arr[i];
            if(temp[1]==i) continue;
            int presentIndex=map.get(i);
            arr[presentIndex]=temp;
            map.put(temp[1],presentIndex);
            cnt++;
        }
        return cnt;
    }
    public int sumOfDigits(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
}