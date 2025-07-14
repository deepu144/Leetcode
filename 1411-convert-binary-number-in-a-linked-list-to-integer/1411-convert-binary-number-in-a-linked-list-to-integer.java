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
class Solution {
    public int getDecimalValue(ListNode head) {
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        System.out.println(size);
        return helper(size-1,head);
    }
    public int helper(int position,ListNode node){
        if(node==null) return 0;
        if(node.val==0) return helper(position-1,node.next);
        return (int)Math.pow(2,position) + helper(position-1,node.next);
    }
}