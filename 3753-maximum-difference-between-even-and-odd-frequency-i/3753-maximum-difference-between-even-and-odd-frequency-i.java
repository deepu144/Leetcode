class Solution {
    public int maxDifference(String s) {
        int n=s.length(),odd=0,even=101;
        int[] fre=new int[26];
        for(int i=0;i<n;i++){
            fre[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if((fre[i]&1)==0){
                if(fre[i]!=0) even=Math.min(even,fre[i]);
            }
            else odd=Math.max(odd,fre[i]);
        }
        return odd-even;
    }
}