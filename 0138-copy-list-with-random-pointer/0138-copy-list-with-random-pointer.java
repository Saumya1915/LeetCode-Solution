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
        while(curr!=null)
        {

            Node newNode=new Node(curr.val);
            tail.next=newNode;
            tail=tail.next;
            curr=curr.next;
        }

        curr=head;
        Node dummycurr=dummy.next;
        while(curr!=null){
            Node curr2=head;
            Node dummycurr2=dummy.next;
            int count=0;
            while(curr2!=curr.random){

               curr2=curr2.next;
               dummycurr2=dummycurr2.next;
            }
            dummycurr.random=dummycurr2;
            dummycurr=dummycurr.next;
            curr=curr.next;
            
        }
        return dummy.next;

    }
}