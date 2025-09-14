class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Trie root = new Trie();
        int n = queries.length, m= wordlist.length;
        Map<String,Integer> caseIgnore = new HashMap<>();
        Map<String,Integer> vowelIgnore = new HashMap<>();
        for(int i=0;i<m;i++) {
            String word = wordlist[i];
            int len = word.length();
            String lower = word.toLowerCase();
            build(word,root);
            caseIgnore.putIfAbsent(lower,i);

            char[] ch = lower.toCharArray();
            for(int j=0;j<len;j++){
                char c = lower.charAt(j);
                if(isVowel(c)) ch[j]='.';
            }
            vowelIgnore.putIfAbsent(new String(ch),i);
        }
        String[] res = new String[n];
        for(int i=0;i<n;i++){
            if(contains(queries[i],root)) res[i] = queries[i];
            else res[i] = helper(queries[i].toLowerCase(), caseIgnore, vowelIgnore, wordlist);
        }
        return res;
    }

    public String helper(String word, Map<String,Integer> caseIgnore, Map<String,Integer> vowelIgnore, String[] wordlist) {
        int n = word.length();
        int idx = caseIgnore.getOrDefault(word,-1);
        if(idx != -1) return wordlist[idx];
        
        char[] ch = word.toCharArray();
        for(int i=0;i<n;i++){
            if(isVowel(word.charAt(i))) ch[i]='.';
        }
        String vowelIgnoreWord = new String(ch);
        idx = vowelIgnore.getOrDefault(vowelIgnoreWord,-1);
        if(idx != -1) return wordlist[idx];
        return "";
    }

    public boolean isVowel(char ch) {
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }

    public void build(String word, Trie root) {
        Trie temp = root;
        int n = word.length();
        for(int i=0;i<n;i++) {
            char ch = word.charAt(i);
            if(temp.child[ch] == null) temp.child[ch] = new Trie();
            temp = temp.child[ch];
        }
        temp.isEnd=true;
        temp.word=word;
    }

    public boolean contains(String word, Trie root){
        int n = word.length();
        Trie temp = root;
        for(int i=0;i<n;i++) {
            char ch = word.charAt(i);
            if(temp.child[ch] == null) return false;
            temp = temp.child[ch];
        }
        return temp.isEnd;
    }

}
class Trie{
    Trie[] child;
    boolean isEnd;
    String word;
    public Trie() {
        child = new Trie[123];
        isEnd = false;
    }
}