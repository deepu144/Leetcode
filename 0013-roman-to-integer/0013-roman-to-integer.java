class Solution {
    public int romanToInt(String s) {
        int n=s.length(),sum=0;
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=getValue(s.charAt(i));
        for(int i=0;i<n;i++){
            if(i<n-1 && arr[i]<arr[i+1]){
                sum-=arr[i];
                i++;
            }
            sum+=arr[i];
        }
        return sum;
    }
    public int getValue(char ch){
        int val=-1;
        switch(ch){
            case 'I':
                val=1;
                break;
            case 'V':
                val=5;
                break;
            case 'X':
                val=10;
                break;
            case 'L':
                val=50;
                break;
            case 'C':
                val=100;
                break;
            case 'D':
                val=500;
                break;
            case 'M':
                val=1000;
                break;
        }
        return val;
    }
}