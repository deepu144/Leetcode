class Solution {
    final static long MOD=(long)(1e9+7);
    public int countTrapezoids(int[][] points) {
        int n=points.length;
        Map<Integer,Integer> yCount = new HashMap<>();
        for(int[] point : points) yCount.put(point[1],yCount.getOrDefault(point[1],0)+1);
        long a=0,ans=0L;
        for(int cnt : yCount.values()){
            if(cnt>=2){
                long c=((long)cnt*(cnt-1)/2 )% MOD;
                ans = (ans+a*c)%MOD;
                a=(a+c)%MOD;
            }
        }
        return (int)(ans);
    }
}