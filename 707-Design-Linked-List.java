class MyLinkedList {
    ListNode head,tail;
    int size;
    public MyLinkedList() {
        head=null;
        tail=null;
        size=0;
    }
    
    public int get(int index) {
        if(index>=size) return -1;
        int pos=0;
        ListNode temp=head;
        while(temp!=null){
            if(pos==index) return temp.val;
            temp=temp.next;
            pos++;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        if(head==null){
            head=new ListNode(val);
            tail=head;
            size++;
        }else{
            ListNode node=new ListNode(val,head);
            head=node;
            size++;
        }
    }
    
    public void addAtTail(int val) {
        if(tail==null){
            head=new ListNode(val);
            tail=head;
            size++;
        }else{
            tail.next=new ListNode(val);
            tail=tail.next;
            size++;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size) return;
        if(index==0){
            addAtHead(val);
            return;
        }
        if(size==index){
            addAtTail(val);
            return;
        }
        ListNode temp=head;
        int pos=1;
        while(pos<index){
            temp=temp.next;
            pos++;
        }
        ListNode node=new ListNode(val,temp.next);
        temp.next=node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index>=size) return;
        if(index==0){
            head=head.next;
            size--;
            return;
        }
        if(index==size-1){
            ListNode temp=head;
            while(temp.next!=tail){
                temp=temp.next;
            }
            tail=temp;
            size--;
            return;
        }
        ListNode temp=head;
        int pos=1;
        while(pos<index){
            temp=temp.next;
            pos++;
        }
        temp.next=temp.next.next;
        size--;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int _val,ListNode _next){
        val=_val;
        next=_next;
    }
    public ListNode(int _val){
        val=_val;
        next=null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */