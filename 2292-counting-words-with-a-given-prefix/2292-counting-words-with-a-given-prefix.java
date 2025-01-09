class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        TrieNode root=new TrieNode();
        createTrie(pref,root);
        for(String s : words){
            if(isPrefix(s,root)) count++;
        }
        return count;
    }
    public boolean isPrefix(String s,TrieNode node){
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(node.child[ch-'a']==null) return false;
            node=node.child[ch-'a'];
            if(node.isLeaf) return true;
        }
        return node.isLeaf;
    }
    public void createTrie(String pref,TrieNode root){
        int i=0,n=pref.length();
        TrieNode temp=root;
        while(i<n){
            int ind=pref.charAt(i)-'a';
            temp.child[ind]=new TrieNode();
            temp=temp.child[ind];
            i++;
        }
        temp.isLeaf=true;
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