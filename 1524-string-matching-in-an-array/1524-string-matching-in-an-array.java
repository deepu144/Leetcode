class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int n=words.length;
        for(int i=0;i<words.length;i++){
            if(isSubstring(words,words[i],i,n)) res.add(words[i]);
        }
        return res;
    }
    public boolean isSubstring(String[] words,String s,int except,int n){
        for(int i=0;i<n;i++){
            if(i==except) continue;
            if(words[i].contains(s)) return true;
        }
        return false;
    }
}