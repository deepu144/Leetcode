class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        ListNode head = new ListNode(nums[0]),temp=head;
        for(int i=1;i<n;i++){
            temp.next = new ListNode(nums[i]);
            temp=temp.next;
        }
        while(head.next!=null){
            ListNode newHead=new ListNode((head.val + head.next.val)%10);
            temp=newHead;
            head=head.next;
            while(head.next!=null){
                temp.next = new ListNode((head.val+head.next.val)%10);
                head=head.next;
                temp=temp.next;
            }
            head = newHead;
        }
        return head.val;
    }
}
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}