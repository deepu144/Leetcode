class Solution {
    public int minMaxDifference(int num) {
        int tot = (int)(Math.log10(num))+1;
        int[] max = new int[tot];
        int[] min = new int[tot];
        int i=tot-1;
        while(num>0){
            int digit = num%10;
            max[i]=min[i]=digit;
            i--;
            num/=10;
        }
        return helper(max,tot,9)-helper(min,tot,0);
    }
    public int helper(int[] arr,int n,int change){
        int digit=-1,i=0;
        while(i<n && arr[i]==change) i++;
        if(i>=n) return convertToNumber(arr,n);
        digit = arr[i];
        for(int j=i;j<n;j++) if(arr[j]==digit) arr[j]=change;
        return convertToNumber(arr,n);
    }
    public int convertToNumber(int[] arr,int n){
        int res=0,temp=1;
        for(int i=0;i<n;i++) res = (res * 10) + arr[i];
        return res;
    }
}