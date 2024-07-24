class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        Pair[] p = new Pair[n];
        for(int i=0;i<n;i++){
            int temp = nums[i];
            if(temp>0){
                int f = 1;
                int map = 0;
                while (temp > 0)
                {
                    map = map + mapping[temp%10]*f;
                    f = f*10;
                    temp = temp/10;
                }
                p[i]=new Pair(nums[i],map);
            }else{
                p[i]=new Pair(nums[i],mapping[temp]);
            }
        }
        Arrays.sort(p,(a,b)->a.map-b.map);
        for(int i=0;i<n;i++){
            nums[i]=p[i].val;
        }
        return nums;
    }
}

class Pair{
    int val;
    int map;
    public Pair(int val,int map){
        this.val=val;
        this.map=map;
    }
}