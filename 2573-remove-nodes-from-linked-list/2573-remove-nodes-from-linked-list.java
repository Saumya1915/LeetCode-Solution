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

    public ListNode reverse(ListNode head){

        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){

            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        head=reverse(head);
        ListNode curr=head;
        ListNode prev=null;
        int largest=head.val;

        while(curr!=null){

            if(curr.val>=largest){
                largest=curr.val;
                prev=curr;
                curr=curr.next;
                
            }
            else{
                prev.next=curr.next;
                curr=curr.next;
            }
            

        }
        return reverse(head);
        
    }
}