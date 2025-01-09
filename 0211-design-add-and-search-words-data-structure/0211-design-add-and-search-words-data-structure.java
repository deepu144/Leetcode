class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        insert(word);
    }
    
    public boolean search(String word) {
        int n=word.length();
        return search(word,0,n,root);
    }
    public boolean search(String word,int i,int n,TrieNode node){
        TrieNode temp=node;
        for(int j=i;j<n;j++){
            char ch=word.charAt(j);
            if(ch=='.'){
                boolean res=false;
                for(int k=0;k<26;k++){
                    if(temp.child[k]!=null){
                        res|=search(word,j+1,n,temp.child[k]);
                        if(res) return true;
                    }
                }
                return false;
            }else{
                if(temp.child[ch-'a']==null) return false;
                temp=temp.child[ch-'a'];
            }
        }
        return temp.isLeaf;
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
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */