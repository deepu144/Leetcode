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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode check=null,first=head,second=head.next;
        while(first!=null && second!=null){
            ListNode next=second.next;
            second.next=first;
            first.next=next;
            if(check==null) head=second;
            else check.next=second;
            check=first;
            if(first.next!=null){
                first=first.next;
                second=first.next;
            }else break;
        }
        return head;
    }
}