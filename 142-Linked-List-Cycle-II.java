/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> li = new HashSet<>();
        ListNode temp = head;
        while(temp!=null){
            if(li.add(temp)) temp=temp.next;
            else return temp;
        }
        return null;
    }
}