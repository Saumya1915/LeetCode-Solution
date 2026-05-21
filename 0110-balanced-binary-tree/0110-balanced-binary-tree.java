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
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int a=height(root.left);
        if(a==-1){
            return -1;
        }

        int b=height(root.right);
        if(b==-1){
            return -1;
        }

        if(Math.abs(a-b)>1){
            return -1;
        }
        return Math.max(a,b)+1;


    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int a=height(root);
        return a==-1?false:true;


        
    }
}