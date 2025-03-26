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
        int n=0;
        if(head==null){
            return new int[1];
        }
        ArrayList<Integer>list=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){

            n++;
            list.add(curr.val);
            curr=curr.next;
        }
        int array[]=new int[n];
        Stack<Integer>stack=new Stack<>();
        for(int i=list.size()-1;i>=0;i--)
        {
            while(!stack.isEmpty() && stack.peek()<=list.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                array[i]=0;
                stack.push(list.get(i));
            }
            else{
                array[i]=stack.peek();
                stack.push(list.get(i));
                
            }
            
        }
        return array;


        
    }
}