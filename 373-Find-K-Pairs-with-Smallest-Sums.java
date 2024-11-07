class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m=nums1.length,n=nums2.length;
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<Triplet> pq=new PriorityQueue<>((a,b)->a.sum-b.sum);
        for(int i=0;i<Math.min(k,m);i++) pq.offer(new Triplet(nums1[i]+nums2[0],i,0));
        while(!pq.isEmpty() && k-->0){
            Triplet p=pq.poll();
            ans.add(Arrays.asList(nums1[p.i],nums2[p.j]));
            if(p.j+1<n) pq.offer(new Triplet(nums1[p.i]+nums2[p.j+1],p.i,p.j+1));
        }
        return ans;
    }
}
class Triplet{
    int sum,i,j;
    public Triplet(int _sum,int _i,int _j){
        sum=_sum;
        i=_i;
        j=_j;
    }
}