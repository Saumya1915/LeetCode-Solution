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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>list=new ArrayList<>();
        if(root==null){

            return list;
        }

        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> innerList=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node=q.remove();
            if(node==null){
                list.add(new ArrayList<>(innerList));
                innerList.clear();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else{
            innerList.add(node.val);
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }}


        }
        return list;
        
    }
}