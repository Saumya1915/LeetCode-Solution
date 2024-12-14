class Solution {
    public int solve(int[][] grid,int x,int y,int[][] dp)
    {
         if(x<0 || y<0 || x>=grid.length || y>=grid[0].length)
         {
            return Integer.MAX_VALUE;
         }

        if(x==0 && y==0){
            return grid[x][y];
        }
        
        if(dp[x][y]!=-1)
        {
            return dp[x][y];

        }

        int up=solve(grid,x-1,y,dp);
        int down=solve(grid,x,y-1,dp);

        dp[x][y]=grid[x][y]+Math.min(up,down);
        return grid[x][y]+Math.min(up,down);
    }
    public int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];

        for(int [] row:dp){
            Arrays.fill(row,-1);
        }
        
        return solve(grid,grid.length-1,grid[0].length-1,dp);
    }
}