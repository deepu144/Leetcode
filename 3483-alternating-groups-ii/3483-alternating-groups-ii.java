class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] arr = new int[n*2];
        for(int i=0;i<n;i++){
            arr[i]=arr[n+i]=colors[i];
        } 
        int l=0,r=0;
        int ans=0;
        while(l<n){
            if(r-l==k-1){
                ans++;
                l++;
            }
            if((r+1)<(n*2) && arr[r]!=arr[r+1]){
                r++;
            }else{
                r++;
                l=r;
            }
        }
        return ans;
    }
}