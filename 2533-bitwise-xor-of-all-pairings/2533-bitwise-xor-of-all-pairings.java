class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int res=0,m=nums1.length,n=nums2.length;
        if((n&1)==0 && (m&1)==0) return res;
        if((n&1)==1 && (m&1)==1){
            for(int i=0;i<m;i++) res^=nums1[i];
            for(int i=0;i<n;i++) res^=nums2[i];
            return res;
        }
        if((n&1)==0) for(int i=0;i<n;i++) res^=nums2[i];
        if((m&1)==0) for(int i=0;i<m;i++) res^=nums1[i];
        return res;
    }
}