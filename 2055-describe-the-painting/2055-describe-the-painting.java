class Solution {
    final int n=100001;
    public List<List<Long>> splitPainting(int[][] segments) {
        long[] sweep=new long[n];
        long last=-1,sum=0;
        boolean[] point=new boolean[n];
        List<List<Long>> ans=new ArrayList<>();
        for(int[] a : segments){
            sweep[a[0]]+=a[2];
            sweep[a[1]]-=a[2];
            point[a[0]]=point[a[1]]=true;
        }
        for(int i=1;i<n;i++){
            if(point[i] && sum>0) ans.add(Arrays.asList(last,(long)i,sum));
            last=point[i]?i:last;
            sum+=sweep[i];
        }
        return ans;
    }
}