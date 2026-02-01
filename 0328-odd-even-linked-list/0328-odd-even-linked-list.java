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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode temp = head, oddPrev = null, evenPrev = null, oddHead = null, evenHead = null;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if((cnt & 1) == 1){
                if(oddHead == null) oddHead = oddPrev = new ListNode(temp.val);
                else{
                    oddPrev.next = new ListNode(temp.val);;
                    oddPrev = oddPrev.next;
                }
            }else{
                if(evenHead == null) evenHead = evenPrev = new ListNode(temp.val);
                else{
                    evenPrev.next = new ListNode(temp.val);
                    evenPrev = evenPrev.next;
                }
            }
            temp = temp.next;
        }
        oddPrev.next = evenHead;
        return oddHead;
    }
}