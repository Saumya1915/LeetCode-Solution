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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        ListNode curr1=l1;
        ListNode curr2=l2;
        while(curr1!=null && curr2!=null)
        {
            int num=curr1.val+curr2.val+carry;
            ListNode newNode=new ListNode(num%10);
            tail.next=newNode;
            tail=tail.next;
            carry=num/10;
            curr1=curr1.next;
            curr2=curr2.next;

        }
        while(curr1!=null){
           int num=curr1.val+carry;
           ListNode newNode=new ListNode(num%10);
            carry=num/10;
            curr1=curr1.next;
            tail.next=newNode;
            tail=newNode;


        }

        while(curr2!=null){
           int num=curr2.val+carry;
           ListNode newNode=new ListNode(num%10);
            carry=num/10;
            curr2=curr2.next;
            tail.next=newNode;
            tail=newNode;


        }
        while(carry>0){
          ListNode newNode=new ListNode(carry%10);
          tail.next=newNode;
           tail=newNode;
          carry/=10;
        }
        return dummy.next;
    }
}