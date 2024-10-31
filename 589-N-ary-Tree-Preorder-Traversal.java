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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        preOrder(root,res);
        return res;
    }
    public void preOrder(Node node,List<Integer> res){
        res.add(node.val);
        for(Node n : node.children) preOrder(n,res);
    }
}