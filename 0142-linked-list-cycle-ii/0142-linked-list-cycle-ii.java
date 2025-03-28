/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detect(ListNode head){

        if(head==null || head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(slow!=null && fast!=null){
            fast=fast.next;
            slow=slow.next;
            if(fast!=null){
                fast=fast.next;
            }
            if(slow==fast){
                return slow;
            }
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {

        ListNode intersection=detect(head);
        if(intersection==null){
            return null;
        }
        ListNode slow=head;
        while(slow!=intersection){
            slow=slow.next;
            intersection=intersection.next;
        }
        return slow;
        




        
    }
}