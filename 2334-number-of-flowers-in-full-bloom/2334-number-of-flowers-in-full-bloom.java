class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n=flowers.length,m=people.length;
        int[] st=new int[n];
        int[] end=new int[n];
        for(int i=0;i<n;i++){
            st[i]=flowers[i][0];
            end[i]=flowers[i][1]+1;
        }
        Arrays.sort(st);
        Arrays.sort(end);
        int[] res=new int[m];
        for(int i=0;i<m;i++){
            int totalBloomed=getCeil(people[i],st,n);
            int bloomStopped=getCeil(people[i],end,n);
            res[i]=totalBloomed-bloomStopped;
        }
        return res;
    }
    public int getCeil(int target,int[] arr,int n){
        int start=0,end=n;
        while(start<end){
            int mid = start+(end-start)/2;
            if(arr[mid]>target){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}