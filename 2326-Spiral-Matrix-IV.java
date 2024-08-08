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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(arr[i],-1);
        setMatrix(arr,m,n,head,0,-1,0,1);
        return arr;
    }
    public void setMatrix(int[][] arr,int r,int c,ListNode head,int rh,int ch,int dr,int dc){
        if(head==null || r==0 || c==0) return;
        for(int i=0;i<c && head!=null;i++){
            rh+=dr;
            ch+=dc;
            arr[rh][ch]=head.val;
            head=head.next;
        }
        if(head==null) return;
        setMatrix(arr,c,r-1,head,rh,ch,dc,-dr);
    }
}