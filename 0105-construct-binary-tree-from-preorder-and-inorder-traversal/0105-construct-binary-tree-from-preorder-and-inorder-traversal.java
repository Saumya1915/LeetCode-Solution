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
    int pre=0;
    public int findPosition(int[] inorder, int start,int end,int element){

        for(int i=start;i<=end;i++){
            if(inorder[i]==element){
                inorder[i]=-1;
                return i;
            }
        }
        return 0;
    }
    public TreeNode solve(int[] preorder, int[] inorder,int start,int end){
        if(pre>=preorder.length || start>end){
            return null;
        }

        int element=preorder[pre++];
        int index=findPosition(inorder,start,end,element);
        TreeNode node=new TreeNode(element);
        node.left=solve(preorder,inorder,start,index-1);
        node.right=solve(preorder,inorder,index+1,end);
        return node;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder,inorder,0,preorder.length-1);
    }
}