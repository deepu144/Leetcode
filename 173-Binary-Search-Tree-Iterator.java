/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    List<Integer> li = new ArrayList<>();
    int i;
    public BSTIterator(TreeNode root) {
        insert(root);
        i=0;
    }

    public void insert(TreeNode root){
        if(root==null) return;
        insert(root.left);
        li.add(root.val);
        insert(root.right);
    }
    
    public int next() {
        return li.get(i++);
    }
    
    public boolean hasNext() {
        return li.size()!=i;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */