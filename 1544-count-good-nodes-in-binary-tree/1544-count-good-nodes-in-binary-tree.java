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
    int count=0;
    public void dfs(int greatest,TreeNode root){

        if(root==null){
            return;

        }
        if(root.val>=greatest){
            count++;
            greatest=root.val;
        }
        dfs(greatest,root.left);
        dfs(greatest,root.right);

    }
    public int goodNodes(TreeNode root) {

        dfs(Integer.MIN_VALUE,root);
        return count;
    }
}