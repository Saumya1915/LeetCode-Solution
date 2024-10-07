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
    public boolean isEvenOddTree(TreeNode root) {
        
        boolean even=true;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            
            int size=q.size();
            int mini=Integer.MIN_VALUE;
            int maxi=Integer.MAX_VALUE;
            for(int i=0;i<size;i++)
            {

                TreeNode node=q.remove();
                if(even){
                    
                    
                    if(node.val<=mini || node.val%2==0){
                        System.out.println(node.val);
                        return false;
                    }
                    mini=node.val;

                }
                else{
                    if(node.val>=maxi|| node.val%2!=0){
                        System.out.println(node.val);

                        return false;
                    }
                    maxi=node.val;

                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null ){
                    q.add(node.right);
                }
            }
            even=!even;
        }
        return true;

    }
}