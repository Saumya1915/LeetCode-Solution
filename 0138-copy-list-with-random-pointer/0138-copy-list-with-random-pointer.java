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
        //HashMap<Node, Node>map=new HashMap<>();
        while(curr!=null)
        {

            Node newNode=new Node(curr.val);
            tail.next=newNode;
            tail=tail.next;
            //map.put(curr,tail);
            curr=curr.next;
        }

        curr=head;
        Node curr2=dummy.next;
        while(curr!=null){

            Node temp=curr.next;
            Node next=curr2.next;
            curr.next=curr2;
            curr2.next=temp;
            curr2=next;
            curr=temp;

        }
        curr=head;

        while(curr!=null){
            if (curr.random != null)
            curr.next.random=curr.random.next;
            curr=curr.next.next;
        }

        curr=head;
        Node dummyhead=new Node(-1);
        tail=dummyhead;
        while(curr!=null){

            tail.next=curr.next;
            curr.next=curr.next.next;
            tail=tail.next;
            curr=curr.next;
        }
        return dummyhead.next;


    

       
        

        

    }
}