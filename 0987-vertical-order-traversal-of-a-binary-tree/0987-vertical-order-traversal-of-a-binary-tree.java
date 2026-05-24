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
    int col;
    int row;
    TreeNode node;
    Pair(int col,int row, TreeNode node)
    {
        this.row=row;
        this.col=col;
        this.node=node;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        List<List<Integer>>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(0,0,root));
        while(!q.isEmpty())
        {

            Pair pair=q.remove();
            int col=pair.col;
            int row=pair.row;
            map.putIfAbsent(col,new TreeMap<>());
            map.get(col).putIfAbsent(row,new PriorityQueue<>());
            map.get(col).get(row).offer(pair.node.val);
            
            if(pair.node.left!=null){
                q.add(new Pair(pair.col-1,pair.row+1,pair.node.left));
            }
            if(pair.node.right!=null){
                q.add(new Pair(pair.col+1,pair.row+1,pair.node.right));
            }
        }
        //System.out.println(tree);
        for(TreeMap<Integer, PriorityQueue<Integer>>rows:map.values()){
            ArrayList<Integer>temp=new ArrayList<>();
            for(PriorityQueue<Integer>pq:rows.values()){
                while(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
            list.add(temp);
        }
        return list;



    
        
    }
}