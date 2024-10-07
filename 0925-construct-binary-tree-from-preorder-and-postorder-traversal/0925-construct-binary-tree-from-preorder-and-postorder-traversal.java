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
    int index=0;
    public TreeNode solve(int start,int end,int[] preorder,int[] postorder,HashMap<Integer,Integer>map){
        if(start>end){
            return null;
        }
        TreeNode node=new TreeNode(preorder[index++]);
        if(start==end){
            return node;
        }
        int num=map.get(preorder[index]);
        node.left=solve(start,num,preorder,postorder,map);
        node.right=solve(num+1,end-1,preorder,postorder,map);
        return node;


    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        return solve(0,preorder.length-1,preorder,postorder,map);
    }
}