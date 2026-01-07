class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<Math.min(k,n);i++) pq.offer(new int[]{nums1[i]+nums2[0],i,0});
        List<List<Integer>> ans = new ArrayList<>();
        while(k-->0 && !pq.isEmpty()){
            int[] peek = pq.poll();
            int i = peek[1], j = peek[2];
            ans.add(List.of(nums1[i],nums2[j]));
            if(j+1 < m) pq.offer(new int[]{nums1[i]+nums2[j+1],i,j+1});
        }
        return ans;
    }
}