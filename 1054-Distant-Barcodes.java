class Solution {
    public int[] rearrangeBarcodes(int[] arr){
        int n=arr.length,j=0,max=0;
        int[] hash=new int[10001];
        for(int i : arr){
            hash[i]++;
            if(hash[i]>hash[max]) max=i;
        }
        while(hash[max]-->0){
            arr[j]=max;
            j+=2;
        }
        for(int i=1;i<10001;i++){
            if(hash[i]==0) continue;
            while(hash[i]-->0){
                if(j>=n) j=1;
                arr[j]=i;
                j+=2;
            }
        }
        return arr;
    }
}