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
    public ListNode solve(ListNode first, ListNode second){
        if(first.next==null){
            first.next=second;
            return first;
        }
        ListNode head=first;
        ListNode firstKeBaad=first.next;
        while(second!=null && firstKeBaad!=null){
            if(second.val>=first.val && second.val<firstKeBaad.val){

                ListNode temp=second.next;
                first.next=second;
                second.next=firstKeBaad;

                first=second;
                second=temp;


            }
            else{
                first=first.next;
                firstKeBaad=first.next;
                if(firstKeBaad==null){
                    first.next=second;}
            
            }
        }
        return head;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        
        if(list1.val>list2.val){
            return solve(list2,list1);
        }
        else{
            return solve(list1,list2);
        }
    }
}