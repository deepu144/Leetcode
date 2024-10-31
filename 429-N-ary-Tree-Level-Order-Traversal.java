/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> li=new ArrayList<>();
        if(root!=null) order(root,0,li);
        return li;
    }
    public void order(Node root,int index,List<List<Integer>> li){
        if(index==li.size()) li.add(new ArrayList<>());
        li.get(index).add(root.val);
        for(Node n : root.children) order(n,index+1,li);
        
    }
}