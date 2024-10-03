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
    StringBuilder str=new StringBuilder();
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        str.append("(");
        str.append(String.valueOf(root.val));
        dfs(root.left);
        if(root.left==null && root.right!=null){
            str.append("()");
        }
        dfs(root.right);
        
        str.append(")");
        
    }
    public String tree2str(TreeNode root) {
        dfs(root);
        str=str.deleteCharAt(str.length()-1);
        str=str.deleteCharAt(0);
       return str.toString();  
         
        
    }
}