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
    HashMap<Long,Integer>map=new HashMap<>();
    public void solve(TreeNode root, int targetSum,long sum){
        if(root==null){
            return;
        }
        sum+=root.val;
        if(sum-targetSum==0){
            count++;
        }
        if(map.containsKey(sum-targetSum)){
            count+=map.get(sum-targetSum);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        solve(root.left,targetSum,sum);
        solve(root.right,targetSum,sum);
        map.put(sum,map.getOrDefault(sum,0)-1);
        if(map.get(sum)==0){
            map.remove(sum);
        }
        //System.out.println(map);

    }                                   
    public int pathSum(TreeNode root, int targetSum) {
        solve(root,targetSum,0);
        return count;
        
    }
}