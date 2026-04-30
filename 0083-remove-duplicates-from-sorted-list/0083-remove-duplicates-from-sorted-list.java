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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        HashSet<Integer> set=new HashSet<>();
        ListNode curr=head;
        ListNode prev=new ListNode(-1);
        ListNode head2=prev;
        while(curr!=null){

            if(set.contains(curr.val)){
                curr=curr.next;
            }
            else{
                set.add(curr.val);
                prev.next=curr;
                prev=curr;
                curr=curr.next;
            }

        }
        prev.next=null;
        return head2.next;
    }
}