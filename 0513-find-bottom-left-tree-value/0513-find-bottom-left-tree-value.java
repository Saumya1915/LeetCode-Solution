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
    public int leftMostValue(TreeNode root,int realheight,int height){

        if(root==null){
            return Integer.MAX_VALUE;
        }
        if(root.left==null && root.right==null){
            if(height==realheight){
                  return root.val;
            }
            else{
                return Integer.MAX_VALUE;
            }
        }
        int p=leftMostValue(root.left,realheight,height+1);
        if(p!=Integer.MAX_VALUE){
            return p;
        }
        int p1=leftMostValue(root.right,realheight,height+1);
        if(p1!=Integer.MAX_VALUE){
            return p1;
        }
        return Integer.MAX_VALUE;

    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int a=height(root.left);
        int b=height(root.right);
        return Math.max(a,b)+1;
    }
    public int findBottomLeftValue(TreeNode root) {
        int realheight=height(root);
        int height=1;
        return leftMostValue(root,realheight,height);

       
        
    }
}