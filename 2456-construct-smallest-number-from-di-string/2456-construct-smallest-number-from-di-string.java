class Solution {
    public String smallestNumber(String pattern) {
        boolean[] visit=new boolean[10];
        int n=pattern.length();
        int[] arr=new int[n+1];
        for(int i=1;i<=9;i++){
            arr[0]=i;
            visit[i]=true;
            if(helper(arr,pattern,0,visit,n)){
                StringBuilder sb=new StringBuilder();
                for(int val : arr) sb.append(val);
                return sb.toString();
            }
            arr[0]=i;
            visit[i]=false;
        }
        return "";
    }
    public boolean helper(int[] arr,String s,int ind,boolean[] visit,int n){
        if(ind==n) return true;
        char ch=s.charAt(ind);
        for(int i=1;i<=9;i++){
            if(visit[i]) continue;
            if(ch=='I'){
                if(arr[ind]<i){
                    arr[ind+1]=i;
                    visit[i]=true;
                    if(helper(arr,s,ind+1,visit,n)) return true;
                    arr[ind+1]=0;
                    visit[i]=false;
                }
            }else{
                if(arr[ind]>i){
                    arr[ind+1]=i;
                    visit[i]=true;
                    if(helper(arr,s,ind+1,visit,n)) return true;
                    arr[ind+1]=0;
                    visit[i]=false;
                }
            }
        }
        return false;
    }
}