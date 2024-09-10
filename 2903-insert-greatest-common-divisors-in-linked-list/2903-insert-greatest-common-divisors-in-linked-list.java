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
    int gcd(int a, int b){
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        while(a!=b){
            if(a>b){
                a=a-b;
            }
            else{
                b=b-a;
            }
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        ListNode curr=head;
        while(curr.next!=null){
            tail.next=new ListNode(curr.val);
            tail=tail.next;
            int divisor=gcd(curr.val,curr.next.val);
            ListNode dummy2=new ListNode(divisor);
            tail.next=dummy2;
            tail=tail.next;
            curr=curr.next;
        }
        tail.next=curr;
        return dummy.next;
        
    }
}