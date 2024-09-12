class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] hash = new boolean[26];
        for(char c : allowed.toCharArray())
            hash[c-'a']=true;
        int res=0;
        for(String s : words){
            if(isConsistant(s,hash)) res++;
        }
        return res;
    }
    public boolean isConsistant(String s , boolean[] hash){
        for(int i=0;i<s.length();i++) if(!hash[s.charAt(i)-'a']) return false;
        return true;
    }
}