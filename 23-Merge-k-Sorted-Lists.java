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
        ArrayList<Integer> q = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode l = lists[i];
            while(l!=null){
                q.add(l.val);
                l=l.next;
            }
        }
        Collections.sort(q);
        ListNode ans=null;
        ListNode head=null;
        for(int num : q){
            if(ans==null){
                ans = new ListNode(num,null);
                head=ans;
            }else{
                ans.next=new ListNode(num,null);
                ans=ans.next;
            }
        }
        return head;
    }
}