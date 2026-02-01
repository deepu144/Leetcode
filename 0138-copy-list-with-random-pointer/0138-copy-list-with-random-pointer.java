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
        HashMap<Node,Integer> index = new HashMap<>();
        HashMap<Integer,Node> newMap = new HashMap<>();
        Node temp = head;
        Node newHead = new Node(-1);
        int idx = 0;
        while(temp != null){
            index.put(temp,idx++);
            temp = temp.next;
        }
        temp = head;
        Node temp2 = newHead;
        idx = 0;
        while(temp != null){
            temp2.next = new Node(temp.val);
            temp2 = temp2.next;
            newMap.put(idx++,temp2);
            temp = temp.next;
        }
        newHead = newHead.next;
        temp = head;
        temp2 = newHead;
        idx = 0;
        while(temp != null){
            int randomIdx = index.getOrDefault(temp.random, -1);
            if(randomIdx != -1) temp2.random = newMap.get(randomIdx);
            temp = temp.next;
            temp2 = temp2.next;
        }
        return newHead;
    }
}