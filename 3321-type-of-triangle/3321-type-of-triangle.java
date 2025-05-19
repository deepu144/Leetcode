class Solution {
    public String triangleType(int[] nums) {
        if(nums[0]+nums[1] <= nums[2] || nums[1]+nums[2] <= nums[0] || nums[0]+nums[2] <= nums[1]) return "none";
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<3;i++) map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        return getType(map.size());
    }
    public String getType(int val){
        String s = "";
        switch(val){
            case 1 :
                s="equilateral";
                break;
            case 2 :
                s="isosceles";
                break;
            case 3 : 
                s="scalene";
                break; 
        }
        return s;
    }
}