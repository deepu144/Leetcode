class Solution {
    TrieNode root;
    final int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public List<String> findWords(char[][] board, String[] words) {
        root=new TrieNode();
        int r=board.length,c=board[0].length;
        List<String> res=new ArrayList<>();
        for(int i=0;i<words.length;i++) insert(words[i],i);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                char ch=board[i][j];
                if(root.child[ch-'a']!=null){
                    search(words,board,r,c,i,j,root.child[ch-'a'],res);
                }
            }
        }
        return res;
    }
    public void search(String[] word,char[][] board,int r,int c,int i,int j,TrieNode node,List<String> res){
        if(node.isLeaf){
            res.add(word[node.index]);
            node.isLeaf=false;
        }
        for(int[] a : dir){
            int x=a[0]+i;
            int y=a[1]+j;
            if(x<0||y<0||x>=r||y>=c||board[x][y]=='.') continue;
            char temp=board[i][j];
            if(node.child[board[x][y]-'a']!=null){
                board[i][j]='.';
                search(word,board,r,c,x,y,node.child[board[x][y]-'a'],res);
                board[i][j]=temp;
            }
        }
    }
    public void insert(String word,int index){
        TrieNode node=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            int ind=word.charAt(i)-'a';
            if(node.child[ind]==null) node.child[ind]=new TrieNode();
            node=node.child[ind];
        }
        node.isLeaf=true;
        node.index=index;
    }
}
class TrieNode{
    boolean isLeaf;
    TrieNode[] child;
    int index;
    public TrieNode(){
        isLeaf=false;
        child=new TrieNode[26];
        index=-1;
    }
}