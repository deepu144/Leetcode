class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n=nums1.length,j=0;
        int[] res=new int[n];
        int[][] mat=new int[n][2];
        List<Integer> li=new ArrayList<>();
        Arrays.sort(nums1);
        for(int i=0;i<n;i++){
            mat[i] = new int[]{nums2[i],i};
            res[i]=-1;
        }
        Arrays.sort(mat,(a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            int[] p = mat[i];
            while(j<n && p[0]>=nums1[j]) li.add(nums1[j++]);
            if(j<n) res[p[1]]=nums1[j++];
        }
        j=0;
        for(int i=0;i<n;i++) if(res[i]==-1) res[i]=li.get(j++);
        return res;
    }
}