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
    public TreeNode dfs(TreeNode root,int height,int realHeight){
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            if(realHeight==height){
                return root;
            }
            else{
                return null;
            }
        }
        TreeNode val1=dfs(root.left,height+1,realHeight);
        TreeNode val2=dfs(root.right,height+1,realHeight);
        if(val1!=null && val2!=null){
            return root;
        }
        else if(val1==null && val2!=null){
            return val2;
        }
        else{
            return val1;
        }
    }
    public int height(TreeNode root){

        if(root==null){
            return 0;
        }
        int a=height(root.left);
        int b=height(root.right);
        return Math.max(a,b)+1;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int realHeight=height(root);
        return dfs(root,1,realHeight);
    }
}