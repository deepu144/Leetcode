class Solution {
    final int MOD=(int)(1e9+7);
    public int maxSum(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        long[] prefix1=new long[m];
        long[] prefix2=new long[n];
        Map<Integer,Integer> hash=new HashMap<>();
        long sum=0;
        for(int i=0;i<m;i++){
            hash.put(nums1[i],i);
            sum+=nums1[i];
            prefix1[i]=sum;
        }
        List<Junction> jun=new ArrayList<>();
        sum=0;
        for(int i=0;i<n;i++){
            sum+=nums2[i];
            prefix2[i]=sum;
            if(hash.containsKey(nums2[i])){
                jun.add(new Junction(hash.get(nums2[i]),i,nums2[i]));
            }
        }
        if(jun.size()==0) return (int)(Math.max(prefix1[m-1],prefix2[n-1])%MOD);
        sum=0L;
        Junction first=jun.getFirst();
        sum=Math.max(prefix1[first.i],prefix2[first.j]);
        for(int i=1;i<jun.size();i++){
            Junction curr=jun.get(i);
            Junction prev=jun.get(i-1);
            long sum1=prefix1[curr.i]-prefix1[prev.i];
            long sum2=prefix2[curr.j]-prefix2[prev.j];
            sum+=Math.max(sum1,sum2);
        }
        Junction last=jun.getLast();
        long sum1=prefix1[m-1]-prefix1[last.i];
        long sum2=prefix2[n-1]-prefix2[last.j];
        sum+=Math.max(sum1,sum2);
        return (int)(sum%MOD);
    }
}
class Junction{
    int i,j,val;
    public Junction(int _i,int _j,int _val){
        i=_i;
        j=_j;
        val=_val;
    }
}