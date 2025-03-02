class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int[] a : nums1) map.put(a[0],map.getOrDefault(a[0],0)+a[1]);
        for(int[] a : nums2) map.put(a[0],map.getOrDefault(a[0],0)+a[1]);
        int[][] res=new int[map.size()][2];
        int i=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            res[i++]=new int[]{entry.getKey(),entry.getValue()};
        }
        return res;
    }
}