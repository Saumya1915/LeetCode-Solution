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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode>ad=new LinkedList<>();
        ad.add(root);
        boolean flag=true;
        while(!ad.isEmpty()){
            int size=ad.size();
            List<Integer>ans=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node=ad.remove();
                ans.add(node.val);
                if(node.left!=null){
                    ad.add(node.left);
                }
                if(node.right!=null){
                    ad.add(node.right);
                }
            }
            if(!flag){
                Collections.reverse(ans);
            }
            list.add(ans);
            flag=!flag;
        }
        return list;
        

    }
}