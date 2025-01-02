class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length,m=queries.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            String s=words[i];
            if(isVowel(s.charAt(0)) && isVowel(s.charAt(s.length()-1))) arr[i]=1;
        }
        for(int i=1;i<n;i++) arr[i]+=arr[i-1];
        int[] res=new int[m];
        for(int i=0;i<m;i++){
            int[] a=queries[i];
            if(a[0]==0) res[i]=arr[a[1]];
            else res[i]=(arr[a[1]]-arr[a[0]-1]);
        }
        return res;
    }
    public boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}