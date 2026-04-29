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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode curr=head;
        ListNode prev=null;
        ListNode forward=null;
        int count=0;
        while(curr!=null && count<k){
            curr=curr.next;
            count++;
        }

        if(count!=k){
            return head;
        }
        count=0;
        curr=head;

        
        while(curr!=null && count<k){
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
            count++;
        }
        head.next=reverseKGroup(forward,k);
        return prev;
         
    }
}