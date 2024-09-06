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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int max=-1;
        for(int i : nums) max=Math.max(max,i);
        int[] hash=new int[max+1];
        for(int n : nums) hash[n]++;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode temp=dummy;
        ListNode tail=head;
        while(temp.next!=null){
            if(temp.next.val<=max && hash[temp.next.val]!=0){
                temp.next = temp.next.next;
            }
            if(temp.next!=null && (temp.next.val>max || hash[temp.next.val]==0))
                temp=temp.next;
        }
        return dummy.next;
    }
}