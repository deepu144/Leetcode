class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        TrieNode root = new TrieNode("/");
        int n=folder.length;
        for(int i=0;i<n;i++) insert(folder[i],root);
        List<String> ans=new ArrayList<>();
        for(TrieNode node : root.child) getFolderName(node,ans,new StringBuilder("/"+node.name));
        return ans;
    }
    public void getFolderName(TrieNode node,List<String> ans,StringBuilder sb){
        if(node.isLeaf){
            ans.add(sb.toString());
            return;
        }
        for(TrieNode child : node.child){
            int size = sb.length();
            sb.append("/"+child.name);
            getFolderName(child,ans,sb);
            sb.setLength(size);
        }
    }
    public void insert(String folder,TrieNode node){
        StringBuilder sb;
        int n=folder.length(),i=0;
        while(i<n){
            sb=new StringBuilder();
            int j=i+1;
            while(j<n){
                char ch=folder.charAt(j);
                if(ch=='/') break;
                sb.append(ch);
                j++;
            }
            String curr = sb.toString();
            boolean hasFolder=false;
            for(TrieNode child : node.child){
                if(child.name.equals(curr)){
                    if(child.isLeaf) return;
                    node=child;
                    hasFolder=true;
                    break;
                }
            }
            if(!hasFolder){
                TrieNode newNode = new TrieNode(curr);
                node.child.add(newNode);
                node=newNode;
            }
            i=j;
        }
        node.isLeaf=true;
    }
}
class TrieNode{
    boolean isLeaf;
    String name;
    List<TrieNode> child;
    public TrieNode(String name){
        isLeaf=false;
        child=new ArrayList<>();
        this.name=name;
    }
}