class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        Pair[] p = new Pair[n];
        for(int i=0;i<n;i++){
            int map=0;
            for(char c : String.valueOf(nums[i]).toCharArray()){
                int ind = c-48;
                map=(map*10)+mapping[ind];
            }
            p[i]=new Pair(nums[i],map,i);
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
    int i;
    public Pair(int val,int map,int i){
        this.val=val;
        this.map=map;
        this.i=i;
    }
}