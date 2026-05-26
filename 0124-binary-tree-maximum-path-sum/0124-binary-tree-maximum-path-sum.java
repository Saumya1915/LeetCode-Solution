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
    int maxi=Integer.MIN_VALUE;
    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int a=solve(root.left);
        int b=solve(root.right);
        maxi=Math.max(maxi,a+b+root.val);
        if(Math.max(a,b)+root.val<0){
            return 0;
        }
        return Math.max(a,b)+root.val;
    }
    public int maxPathSum(TreeNode root) {

        if(root==null){
            return 0;
        }
        solve(root);
        return maxi;

        
    }
}