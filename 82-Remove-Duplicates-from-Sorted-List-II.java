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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode res=null,temp=null;
        int pre=head.val,count=1;
        head=head.next;
        while(head!=null){
            if(head.val==pre) count++;
            else if(count==1){
                if(res==null){
                    res=new ListNode(pre);
                    temp=res;
                }else{
                    temp.next=new ListNode(pre);
                    temp=temp.next;
                }
                pre=head.val;
            }else{
                pre=head.val;
                count=1;
            }
            head=head.next;
        }
        if(res==null && count==1) return new ListNode(pre);
        if(count==1) temp.next=new ListNode(pre);
        return res;
    }
}