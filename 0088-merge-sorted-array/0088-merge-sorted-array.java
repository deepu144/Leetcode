class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a=nums1.length-1;m--;n--;
        if(m==-1){
            for(int i=0;i<=n;i++) nums1[i]=nums2[i];
            return; 
        }
        while(n>=0 && m>=0){
            if(nums1[m]<=nums2[n]) nums1[a--]=nums2[n--];
            else{
                while(m>=0 && nums1[m]>nums2[n]){
                    int i=m+1;
                    while(i<=a){
                        int t=nums1[i-1];
                        nums1[i-1]=nums1[i];
                        nums1[i]=t;
                        i++;
                    }
                    a--;
                    m--;
                }
                if(m==-1){
                    for(int i=0;i<=n;i++) nums1[i]=nums2[i];
                    return;
                }
                nums1[a--]=nums2[n--];
            }
        }
    }
}