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
            boolean ans = check(list,node,list);
            if(ans){
                res=1;
                return;
            }
        }
        dfs(list,node.left);
        dfs(list,node.right);
    }
    public boolean check(ListNode list,TreeNode node,ListNode temp){
        if(temp==null && node!=null) return true;
        if(temp!=null && node!=null){
            if(node.val==temp.val){
                boolean l = check(list,node.left,temp.next);
                boolean r = check(list,node.right,temp.next);

                if(l||r) return true;
            }else{
                boolean l = check(list,node.left,list);
                boolean r = check(list,node.right,list);
                if(l||r) return true;
            }
        }
        if(temp==null && node==null) return true;
        return false;
    }
}