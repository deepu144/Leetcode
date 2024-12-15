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
    public ListNode removeNodes(ListNode head) {
        head=reverse(head);
        ListNode temp=head;
        ListNode pre=temp;
        temp=temp.next;
        while(temp!=null){
            if(pre.val>temp.val) pre.next=temp.next;
            else pre=temp;
            temp=temp.next;
        }
        return reverse(head);
    }
    public ListNode reverse(ListNode node){
        ListNode pre=null,next=null;
        while(node!=null){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        return pre;
    }
}