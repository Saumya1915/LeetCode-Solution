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
    public ListNode middleNode(ListNode head) {
        ListNode noob=head;
        ListNode pro=head.next;
        if(head==null||head.next==null){
            return head;
        }
        while(pro!=null)
        {
            pro=pro.next;
            noob=noob.next;
            if(pro!=null){
                pro=pro.next;
            }
        }
        return noob;
    }
}