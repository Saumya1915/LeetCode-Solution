/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int find(int value,int array[]){
        for(int i=0;i<array.length;i++){
            if(array[i]==value){
                return i;
            }
        }
        return 0;
    }
    public void swap(int index1,int index2,int array[]){
        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }
    public int minimumOperations(TreeNode root) {
        int sum=0;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int array[]=new int[q.size()];
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.remove();
                array[i]=node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            int array2[]=new int[array.length];
            for(int i=0;i<array.length;i++){
                array2[i]=array[i];
            }
            Arrays.sort(array2);
            int j=array.length-1;
            while(j>=0){
                if(array[j]!=array2[j]){
                    int value=find(array[j],array2);
                    swap(j,value,array);
                    sum++;
                }
                else{
                    j--;
                }
            }

        }
        return sum;
        
    }
}