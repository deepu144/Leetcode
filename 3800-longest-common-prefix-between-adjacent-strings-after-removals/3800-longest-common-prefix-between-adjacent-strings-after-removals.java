class Solution {
    public int[] longestCommonPrefix(String[] words) {
        int n=words.length;
        int[] ans=new int[n];
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = prefix(words[i],i-1<0?"":words[i-1]);
            arr[i][1] = prefix(words[i],i+1>=n?"":words[i+1]);
        }
        int[] p=new int[n];
        int[] s=new int[n]; 
        p[0]=Math.max(arr[0][0],arr[0][1]);
        for(int i=1;i<n;i++) p[i]=Math.max(p[i-1],Math.max(arr[i][0],arr[i][1]));
        s[n-1]=Math.max(arr[n-1][0],arr[n-1][1]);
        for(int i=n-2;i>=0;i--) s[i]=Math.max(s[i+1],Math.max(arr[i][0],arr[i][1]));
        for(int i=0;i<n;i++){
            ans[i] = Math.max(i+2>=n ? 0 : s[i+2], i-2<0 ? 0 : p[i-2] );
            int a = prefix(i+1>=n ? "" : words[i+1] , i-1<0 ? "" : words[i-1]);
            ans[i] = Math.max(ans[i],a);
        }
        return ans;
    }
    public int prefix(String s,String t){
        int i=0,j=0,m=s.length(),n=t.length(),cnt=0;
        while(i<m && j<n){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
                cnt++;
            }else return cnt;
        }
        return cnt;
    }
}