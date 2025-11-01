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
        ListNode dummy = new ListNode(-1);
        boolean[] map = new boolean[100001];
        for(int val : nums) map[val]=true;
        dummy.next = head;
        ListNode temp = dummy;
        while(temp.next != null){
            if(map[temp.next.val]) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return dummy.next;
    }
}