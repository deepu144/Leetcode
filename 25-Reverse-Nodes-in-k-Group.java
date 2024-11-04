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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        boolean f=false;
        ListNode temp=head,pre=head,brk=null;
        while(temp!=null){
            count++;
            if(count==k){
                ListNode next=temp.next;
                temp.next=null;
                ListNode reverse=reverse(pre);
                if(!f){
                    head=reverse;
                    f=true;
                }
                if(brk!=null) brk.next=reverse;
                pre.next=next;
                brk=pre;
                count=0;
                temp=pre;
                pre=next;
                ListNode o=head;
            }
            temp=temp.next;
        }
        return head;
    }
    public ListNode reverse(ListNode node){
        ListNode next=null,pre=null;
        while(node!=null){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        return pre;
    }
}