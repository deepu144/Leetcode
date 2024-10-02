class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] dup = arr.clone(); 
        Arrays.sort(dup);
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<dup.length;i++) map.putIfAbsent(dup[i],map.size()+1);
        for(int i=0;i<arr.length;i++) arr[i]=map.get(arr[i]);
        return arr;
    }
}