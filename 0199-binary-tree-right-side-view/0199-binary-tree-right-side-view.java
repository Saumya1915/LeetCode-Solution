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
 class Pair{
    
    int hd;
    TreeNode node;
    
    Pair(int hd,TreeNode node){
        this.node=node;
        this.hd=hd;
    }
}
class Solution {
    public void help(List<Integer>list,TreeNode root,int level){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.val);
        }
        help(list,root.right,level+1);
        help(list,root.left,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        help(list,root,0);
        return list;

        
    }
}