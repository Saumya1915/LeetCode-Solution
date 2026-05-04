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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        if(head.next==null && n==1){
            return null;
        }
        int count=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            count++;
        }

        int num=count-n;
        curr=head;
        if(num==0){
            head=head.next;
            return head;
        }
        ListNode prev=null;
        while(num>0){
            prev=curr;
            curr=curr.next;
            num--;
        }
        prev.next=curr.next;
         return head;


    }
}