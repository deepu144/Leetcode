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
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        return buildTree(inorder, 0, inorder.size() - 1);
    }

    public TreeNode buildTree(List<Integer> inorder, int start, int end) {
        if(start == end) return new TreeNode(inorder.get(start));
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(inorder.get(mid));
        node.left = buildTree(inorder, start, mid - 1);
        node.right = buildTree(inorder, mid + 1, end);

        return node;
    }

    public void inorder(TreeNode node, List<Integer> inorder){
        if(node == null) return;
        inorder(node.left, inorder);
        inorder.add(node.val);
        inorder(node.right, inorder);
    }
}