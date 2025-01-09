class Trie {
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word){
        TrieNode node=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            int ind=word.charAt(i)-'a';
            if(node.child[ind]==null) node.child[ind]=new TrieNode();
            node=node.child[ind];
        }
        node.isLeaf=true;
    }
    
    public boolean search(String word) {
        int n=word.length();
        TrieNode node=root;
        for(int i=0;i<n;i++){
            int ind=word.charAt(i)-'a';
            if(node.child[ind]==null) return false;
            node=node.child[ind];
        }
        return node.isLeaf;
    }
    
    public boolean startsWith(String prefix) {
        int n=prefix.length();
        TrieNode node=root;
        for(int i=0;i<n;i++){
            int ind=prefix.charAt(i)-'a';
            if(node.child[ind]==null) return false;
            node=node.child[ind];
        }
        return true;
    }
}
class TrieNode{
    boolean isLeaf;
    TrieNode[] child;
    public TrieNode(){
        isLeaf=false;
        child=new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */