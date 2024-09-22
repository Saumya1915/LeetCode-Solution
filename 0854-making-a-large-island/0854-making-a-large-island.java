class Solution 
{
    int parent[];
    int rank[];
    
    public int findParent(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = findParent(parent[u]);  // Path compression
    }

    public void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) {
            return;
        }

        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
            rank[pu]+=rank[pv];
        } else if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
            rank[pv]+=rank[pu];
        } else {
            parent[pv] = pu;
            rank[pu]+=rank[pv];
        }
    }

    public int largestIsland(int[][] grid) {
        int row = grid.length;
        parent = new int[row * row];
        rank = new int[row * row];
        int ans[][] = new int[row][row];
        Arrays.fill(rank,1);
        
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // Union-Find for the 1s in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans[i][j] = 1;

                    int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                    for (int[] dis : dir) {
                        int newRow = i + dis[0];
                        int newCol = j + dis[1];

                        if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < row && ans[newRow][newCol] == 1) {
                            int u = i * row + j;
                            int v = newRow * row + newCol;

                            union(u, v);
                        }
                    }
                }
            }
        }

        int maxi = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int count = 1;

                    int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
                    HashSet<Integer> set = new HashSet<>();

                    for (int[] dis : dir) {
                        int newRow = i + dis[0];
                        int newCol = j + dis[1];
                        
                        if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < row && ans[newRow][newCol] == 1) {
                            int num = newRow * row + newCol;
                            int v = findParent(num);
                            if (!set.contains(v)) {
                                count += rank[v];
                                set.add(v);
                            }
                        }
                    }
                    maxi = Math.max(maxi, count);
                }
            }
        }
        if(maxi==0){
            for(int i=0;i<grid.length;i++){

                for(int j=0;j<grid.length;j++){

                    maxi++;
                }
            }
       }

        return maxi;
    }
}
