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
    public ListNode partition(ListNode head, int x) {
        if(head==null) return head;
        ListNode head1=null,head2=null,small=null,large=null,temp=head;
        while(temp!=null){
            if(temp.val<x){
                if(head1==null){
                    head1=new ListNode(temp.val);
                    small=head1;
                }else{
                    small.next=new ListNode(temp.val);
                    small=small.next;
                }
            }else{
                if(head2==null){
                    head2=new ListNode(temp.val);
                    large=head2;
                }else{
                    large.next=new ListNode(temp.val);
                    large=large.next;
                }
            }
            temp=temp.next;
        }
        if(small!=null) small.next=head2;
        else return head2;
        return head1;
    }
}