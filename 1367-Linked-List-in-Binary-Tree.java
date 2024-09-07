/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    int res=0;
    public boolean isSubPath(ListNode head, TreeNode root) {
        dfs(head,root);
        return res==1;
    }
    public void dfs(ListNode list,TreeNode node){
        if(node==null) return;
        if(node.val==list.val){
            boolean ans = check(list,node);
            if(ans){
                res=1;
                return;
            }
        }
        dfs(list,node.left);
        dfs(list,node.right);
    }
    public boolean check(ListNode temp,TreeNode node){
        if(temp==null) return true;
        if(node==null || node.val!=temp.val) return false;
        return check(temp.next,node.left) || check(temp.next,node.right);
    }
}