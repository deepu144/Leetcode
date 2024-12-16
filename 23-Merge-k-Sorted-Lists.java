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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode t : lists) if(t!=null) pq.offer(t);
        ListNode head=null,pre=null;
        while(!pq.isEmpty()){
            ListNode p=pq.poll();
            if(head==null){
                head=p;
                pre=head;
            }else{
                pre.next=p;
                pre=p;
            }
            if(p.next!=null) pq.offer(p.next);
        }
        if(pre!=null) pre.next=null;
        return head;
    }
}