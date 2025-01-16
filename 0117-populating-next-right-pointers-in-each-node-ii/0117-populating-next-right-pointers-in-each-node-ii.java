/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        List<List<Node>> lvl=new ArrayList<>();
        dfs(root,lvl,0);
        for(List<Node> li : lvl){
            int size=li.size();
            for(int i=1;i<size;i++) li.get(i-1).next=li.get(i);
        }
        return root;
    }
    public void dfs(Node node,List<List<Node>> lvl,int level){
        if(node==null) return;
        if(lvl.size()==level) lvl.add(new ArrayList<>());
        lvl.get(level).add(node);
        dfs(node.left,lvl,level+1);
        dfs(node.right,lvl,level+1);
    }
}