class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res=new ArrayList<>();
        int n=words.length,i=1;
        if(n==1) return new ArrayList<>(List.of(words[0]));
        while(i<n){
            int j=i-1;
            while(i<n && isAnagram(words[j],words[i])) i++;
            res.add(words[j]);
            i++;
        }
        if(n>=2 && !isAnagram(words[n-1],words[n-2])) res.add(words[n-1]);
        return res;
    }
    public boolean isAnagram(String s, String t) {
        int[] hash=new int[26];
        int n=s.length();
        if(n!=t.length()) return false;
        for(int i=0;i<n;i++){
            hash[s.charAt(i)-'a']++;
            hash[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++) if(hash[i]!=0) return false;
        return true;
    }
}