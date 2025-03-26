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
    public int[] nextLargerNodes(ListNode head) {
        if(head==null || head.next==null){
            return new int[1];
        }
        int size=0;
        ListNode curr=head;
        while(curr!=null){
            size++;
            curr=curr.next;
        }
        int array[]=new int[size];
        curr=head;
        int a=0;
        while(curr!=null){
            array[a++]=curr.val;
            curr=curr.next;
        }
        Stack<Integer> stack=new Stack<>();
        for(int i=size-1;i>=0;i--){
            while(!stack.isEmpty() && array[i]>=stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(array[i]);
                array[i]=0;
            }
            else{
                int value=stack.peek();
                stack.push(array[i]);
                array[i]=value;
            }
        }
        return array;


        
    }
}