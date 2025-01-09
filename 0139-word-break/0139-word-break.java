class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root=new TrieNode();
        int n=s.length();
        for(String t : wordDict) insert(t,root);
        return helper(s,n,root,0,new Boolean[n]);
    }
    public boolean helper(String s,int n,TrieNode root,int i,Boolean[] dp){
        if(i==n) return true;
        if(dp[i]!=null) return dp[i];
        TrieNode node=root;
        for(int j=i;j<n;j++){
            int ind=s.charAt(j)-'a';
            if(node.child[ind]==null) return dp[i]=false;
            node=node.child[ind];
            if(node.isLeaf){
                if(helper(s,n,root,j+1,dp)) return dp[i]=true;
            }
        }
        return dp[i]=false;
    }
    public void insert(String word,TrieNode root){
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