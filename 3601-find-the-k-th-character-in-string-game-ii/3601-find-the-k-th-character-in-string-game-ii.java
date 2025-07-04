class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n=operations.length;
        char[] arr=new char[26];
        for(char i='a';i<='z';i++) arr[i-'a']=i;
        int ind = (int) Math.ceil( Math.log(k)/Math.log(2) ) - 1;
        for(int i=ind;i>=0;i--){
            long len = (long)Math.pow(2,i+1);
            long half = len/2;
            if(operations[i]==1 && (half+1)<=k && len>=k){
                doSubtract(arr);
                k-=half;
            }else if(operations[i]==0 && (half+1)<=k && len>=k) k-=half;
        }
        for(int i=0;i<26;i++) if(arr[i]=='a') return (char)('a'+i);
        return '#';
    }
    public void doSubtract(char[] arr){
        for(int i=0;i<26;i++){
            char ch=arr[i];
            if(ch=='a') arr[i]='z';
            else arr[i]=(char)(ch-1);
        }
    }
}