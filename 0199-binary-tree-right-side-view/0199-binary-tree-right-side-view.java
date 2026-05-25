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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Pair>q=new LinkedList<>();
        TreeMap<Integer,Integer>map=new TreeMap<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            
            Pair pair=q.remove();
            
            map.put(pair.hd,pair.node.val);
            
            if(pair.node.left!=null){
                q.add(new Pair(pair.hd+1,pair.node.left));
            }
            
            if(pair.node.right!=null){
                q.add(new Pair(pair.hd+1,pair.node.right));
            }
            
            
            
        }
        
        for(Integer value:map.values()){
            
            list.add(value);
        }
        return list;

        
    }
}