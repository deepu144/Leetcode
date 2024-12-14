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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode res=null,temp=null;
        int carry=0;
        while(l1!=null || l2!=null){
            if(res==null){
                res=new ListNode((l1.val+l2.val)%10);
                carry=(l1.val+l2.val)/10;
                l1=l1.next;
                l2=l2.next;
                temp=res;
                continue;
            }
            if(l1!=null && l2!=null){
                int sum=l1.val+l2.val+carry;
                temp.next=new ListNode(sum%10);
                carry=sum/10;
                temp=temp.next;
                l1=l1.next;
                l2=l2.next;
            }else if(l1!=null && l2==null){
                int sum=l1.val+carry;
                temp.next=new ListNode(sum%10);
                carry=sum/10;
                temp=temp.next;
                l1=l1.next;
            }else if(l1==null && l2!=null){
                int sum=l2.val+carry;
                temp.next=new ListNode(sum%10);
                carry=sum/10;
                temp=temp.next;
                l2=l2.next;
            }
        }
        if(carry!=0) temp.next=new ListNode(carry);
        return res;
    }
}