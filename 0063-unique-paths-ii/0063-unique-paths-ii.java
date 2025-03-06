class Solution {
    public int solve(int x,int y,int[][] grid,int dp[][]){

        if(x==0 && y==0){

            return 1;
        }
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==1){

            return 0;
        }

        if(dp[x][y]!=-1){
            return dp[x][y];
        }

        int up=solve(x-1,y,grid,dp);
        int left=solve(x,y-1,grid,dp);
        return dp[x][y]=up+left;





    }

     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
           return 0; 
        }

        int dp[][]=new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return solve(obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid,dp);
        

    }
}