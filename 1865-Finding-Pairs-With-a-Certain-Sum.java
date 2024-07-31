class FindSumPairs {
    HashMap<Integer,Integer> map;
    private int[] nums1;
    private int[] nums2;
    public FindSumPairs(int[] nums1, int[] nums2){
        this.map=new HashMap<>();
        this.nums1=nums1;
        this.nums2=nums2;
        for(int i : nums2){
            map.put(i,map.getOrDefault(i,0)+1);
        }
    }
    public void add(int index, int val){
        map.put(nums2[index],map.get(nums2[index])-1);
        nums2[index]+=val;
        map.put(nums2[index],map.getOrDefault(nums2[index],0)+1);
    }
    public int count(int tot) {
        int count=0;
        for(int i : nums1){
            int k = tot-i;
            if(k>=0 && map.containsKey(k)) count+=map.get(k);
        }
        return count;
    }
}
/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */