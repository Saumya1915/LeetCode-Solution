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
class FindElements {

    public void set(TreeNode root,HashSet<Integer> set,int value) {
        if(root==null){
            return;
        }
        set.add(value);
        set(root.left,set,2*value+1);
        set(root.right,set,2*value+2);
    }
    HashSet<Integer> set=new HashSet<>();
    public FindElements(TreeNode root) {
       set(root,set,0);

    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}
/** 0
  1    2
3   4 5  6   */

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */