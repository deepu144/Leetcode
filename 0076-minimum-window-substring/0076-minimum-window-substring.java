class Solution {
    public String minWindow(String s, String t) {
        int[] hash=new int[126];
        int[] curr=new int[126];
        int n=t.length(),m=s.length(),left=0,right=0,want=n,start=-1,minLength=m+1;
        for(int i=0;i<n;i++) hash[t.charAt(i)]++;
        while(right<m){
            char ch=s.charAt(right);
            if(want!=0){
                if(curr[ch]<hash[ch]){
                    if(want==n) left=right;
                    want--;
                    curr[ch]++;
                }else if(hash[ch]!=0) curr[ch]++;
            }
            while(want==0){
                if(minLength>(right-left+1)){
                    minLength=right-left+1;
                    start=left;
                }
                ch=s.charAt(left);
                curr[ch]--;
                left++;
                if(curr[ch]<hash[ch]) want++;
                while(left<right && curr[s.charAt(left)]==0) left++;
            }
            right++;
        }
        return minLength==m+1?"":s.substring(start,start+minLength);
    }
}
