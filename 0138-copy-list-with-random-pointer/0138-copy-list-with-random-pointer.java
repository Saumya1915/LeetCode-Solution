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
        Node curr=head;
        Node dummy=new Node(-1);
        Node tail=dummy;
        HashMap<Node, Node>map=new HashMap<>();
        while(curr!=null)
        {

            Node newNode=new Node(curr.val);
            tail.next=newNode;
            tail=tail.next;
            map.put(curr,tail);
            curr=curr.next;
        }

        curr=head;
        Node curr2=dummy.next;
        while(curr!=null){
            curr2.random=map.get(curr.random);
            curr2=curr2.next;
            curr=curr.next;
        }
        return dummy.next;
        

        

    }
}