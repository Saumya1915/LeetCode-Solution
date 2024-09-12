class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // Map to handle individual items with no group (-1 case)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                map.put(i, m++); // Assign new group to items with no group
            } else {
                map.put(i, group[i]);
            }
        }

        // Adjacency list for individual items and their indegrees
        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }
        int[] itemIndegree = new int[n];
        for (int i = 0; i < beforeItems.size(); i++) {
            for (int beforeItem : beforeItems.get(i)) {
                itemGraph.get(beforeItem).add(i);
                itemIndegree[i]++;
            }
        }

        // Topological sorting for individual items
        List<Integer> sortedItems = topologicalSort(itemGraph, itemIndegree, n);
        if (sortedItems.size() < n) {
            return new int[0]; // Cycle detected or not all nodes sorted
        }

        // Adjacency list for groups and their indegrees
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }
        int[] groupIndegree = new int[m];
        for (int i = 0; i < beforeItems.size(); i++) {
            int currentGroup = map.get(i);
            for (int beforeItem : beforeItems.get(i)) {
                int beforeGroup = map.get(beforeItem);
                if (currentGroup != beforeGroup) {
                    groupGraph.get(beforeGroup).add(currentGroup);
                    groupIndegree[currentGroup]++;
                }
            }
        }

        // Topological sorting for groups
        List<Integer> sortedGroups = topologicalSort(groupGraph, groupIndegree, m);
        if (sortedGroups.size() < m) {
            return new int[0]; // Cycle detected in groups or not all sorted
        }

        // Map groups to the items within them
        HashMap<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (int i = 0; i < m; i++) {
            groupToItems.put(i, new ArrayList<>());
        }
        for (int item : sortedItems) {
            groupToItems.get(map.get(item)).add(item);
        }

        // Generate the final sorted list based on sorted groups and items
        int[] result = new int[n];
        int index = 0;
        for (int groupId : sortedGroups) {
            for (int item : groupToItems.get(groupId)) {
                result[index++] = item;
            }
        }

        return result;
    }

    // Helper method for topological sorting
    private List<Integer> topologicalSort(List<List<Integer>> graph, int[] indegree, int totalNodes) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> sortedList = new ArrayList<>();
        
        for (int i = 0; i < totalNodes; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.remove();
            sortedList.add(node);
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return sortedList;
    }
}
