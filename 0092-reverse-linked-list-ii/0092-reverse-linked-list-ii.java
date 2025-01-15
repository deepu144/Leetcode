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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        ListNode head2=null,head3=null,temp=head;
        int size=0;
        if(left==1) head2=head;
        while(temp!=null){
            size++;
            if(left==size+1) head2=temp;
            else if(right==size) head3=temp;
            temp=temp.next;
        }
        ListNode a=(left!=1)?head2.next:head,b=head3.next;
        if(left!=1) head2.next=null;
        head3.next=null;
        ListNode reverse=reverseList(a);
        if(left!=1) head2.next=reverse;
        else head=reverse;
        a.next=b;
        return head;
    }
    public ListNode reverseList(ListNode head) {
        ListNode next=null,pre=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}