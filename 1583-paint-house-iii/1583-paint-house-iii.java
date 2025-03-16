class Solution {
    public int solve(int[] houses, int[][] cost, int n, int target, int colors, int prev, int index,int[][][] dp) {
        // Base case 1: If we've processed all houses
        if (index == houses.length) {
            // If we've used exactly the target number of colors, return 0, else return a large number
            return (colors == target) ? 0 : Integer.MAX_VALUE/2;
        }
        
        // Base case 2: If we've used more colors than allowed
        if (colors > target) {
            return Integer.MAX_VALUE/2;
        }

        if(dp[colors][prev][index]!=-1){
            return dp[colors][prev][index];
        }

        int mini = Integer.MAX_VALUE/2;

        if (houses[index] == 0) { // House is not colored yet
            // Try all possible colors for this house
            for (int i = 1; i <= n; i++) {  // i represents the color number (0-indexed)
                mini=Math.min(mini,cost[index][i-1] + solve(houses, cost, n, target, 
                                                        colors + (prev == i ? 0 : 1), i, index + 1,dp));
            }
        } else { // House is already colored
            // No need to add a cost, just check if we change color or not
            mini = Math.min(mini, solve(houses, cost, n, target, 
                                        colors + (prev == houses[index] ? 0 : 1), houses[index] , index + 1,dp));
        }

        return dp[colors][prev][index]=mini;
    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // Call solve starting from index 0, with 0 colors used and prev being 0 (since no house has been painted yet)
        int dp[][][]=new int[target+1][n+1][houses.length];
        for(int[][] rows:dp){
            for(int[] row:rows){
                Arrays.fill(row,-1);
            }
        }
        int result = solve(houses, cost, n, target, 0, 0, 0,dp);
        
        // If the result is Integer.MAX_VALUE, no valid configuration was found, return -1
        return result == Integer.MAX_VALUE/2 ? -1 : result;
    }
}
