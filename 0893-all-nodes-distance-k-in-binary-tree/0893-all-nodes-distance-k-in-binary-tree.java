/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void buildParentMap(HashMap<TreeNode,TreeNode> map, TreeNode root) {
        if (root == null) return;
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        buildParentMap(map, root.left);
        buildParentMap(map, root.right);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(parentMap, root);

        // BFS queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);

        // To track visited nodes and avoid revisiting them
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int distance = 0;

        // Perform BFS
        while (!q.isEmpty()) {
            if (distance == k) {
                // Collect all nodes at distance k
                List<Integer> result = new ArrayList<>();
                for (TreeNode node : q) {
                    result.add(node.val);
                }
                return result;
            }
            
            int size = q.size();
            // Process all nodes at current level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Add left child if not visited
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.add(node.left);
                }

                // Add right child if not visited
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.add(node.right);
                }

                // Add parent if not visited
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    visited.add(parentMap.get(node));
                    q.add(parentMap.get(node));
                }
            }
            distance++;  // Increment distance after processing all nodes at the current level
        }

        return new ArrayList<>();  // Return empty if no nodes are found at distance k
    }
}
