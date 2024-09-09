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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix=new int[m][n];
        for (int[] row: matrix){
             Arrays.fill(row, -1);}
        int startingRow=0;
        int startingCol=0;
        int endingRow=m-1;
        int endingCol=n-1;
         while(head!=null){
             for(int i=startingCol;head!=null && i<=endingCol;i++){
                 matrix[startingRow][i]=head.val;
                 head=head.next;
             }
             startingRow++;

             for(int i=startingRow;head!=null && i<=endingRow;i++){
                 matrix[i][endingCol]=head.val;
                 head=head.next;
             }
             endingCol--;

             for(int i=endingCol;head!=null && i>=startingCol;i--){
                 matrix[endingRow][i]=head.val;
                 head=head.next;
             }
             endingRow--;

             for(int i=endingRow;head!=null && i>=startingRow;i--){
                 matrix[i][startingCol]=head.val;
                 head=head.next;
             }
             startingCol++;

             


         }
         return matrix;

    }
}