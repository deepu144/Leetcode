class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length(),res=0;
        HashMap<Character,Integer> map=new HashMap<>();
        boolean[][] hash=new boolean[26][26];
        int[] repeat=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int preIndex=map.getOrDefault(ch,-1);
            if(preIndex==-1) map.put(ch,i);
            else{
                for(int j=preIndex+1;j<i;j++){
                    char c=s.charAt(j);
                    if(!hash[ch-'a'][c-'a']){
                        res++;
                        hash[ch-'a'][c-'a']=true;
                    }
                }
                repeat[ch-'a']++;
                map.put(ch,i);
            }
        }
        for(int i : repeat) if(i>=2) res++;
        return res;
    }
}