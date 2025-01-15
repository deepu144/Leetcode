/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        HashMap<Node,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> random=new HashMap<>();
        HashMap<Integer,Node> map1=new HashMap<>();
        Node temp=head;
        int id=0;
        while(temp!=null){
            map.put(temp,++id);
            temp=temp.next;
        }
        temp=head;
        id=1;
        while(temp!=null){
            Node p=temp.random;
            if(p==null) random.put(id,-1);
            else random.put(id,map.get(p));
            id++;
            temp=temp.next;
        }
        id=1;
        Node head1=new Node(head.val);
        map1.put(id++,head1);
        Node temp1=head1;
        temp=head.next;
        while(temp!=null){
            temp1.next=new Node(temp.val);
            temp1=temp1.next;
            temp=temp.next;
            map1.put(id++,temp1);
        }
        temp=head1;
        id=1;
        while(temp!=null){
            if(random.get(id)==-1) temp.random=null;
            else temp.random=map1.get(random.get(id));
            temp=temp.next;
            id++;
        }
        return head1;
    }
}