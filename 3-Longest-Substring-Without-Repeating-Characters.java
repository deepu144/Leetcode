class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash= new int[256];
        Arrays.fill(hash,-1);
        int n = s.length();
        if(n<=1){
            return n;
        }
        int a=0,b=0,max=0;
        while(a<n){
            if(b>=n){
                a++;
                continue;
            }
            char c = s.charAt(b);
            if(b<n && hash[c]==-1){
                hash[c]=b+1;
                b++;
            }else if(hash[c]!=-1 && b<n){
                while(a<hash[c] && a<n){
                    hash[s.charAt(a)]=-1;
                    a++;
                }
                hash[c]=-1;
            }
            max=Math.max(max,b-a);
        }
        return max;
    }
}
