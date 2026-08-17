class Solution {
    public int solve(int[][] obstacleGrid,int x,int y,int[][] grid){

        if(x==obstacleGrid.length-1 && y==obstacleGrid[0].length-1 && obstacleGrid[x][y]!=1)
        {
            return 1;
        }

        if(x>=obstacleGrid.length||y>=obstacleGrid[0].length)
        {
            return 0;
        }

        if(grid[x][y]!=-1){
            return grid[x][y];
        }

        if(obstacleGrid[x][y]==1){
            return 0;
        }

        

        int left=solve(obstacleGrid,x+1,y,grid);
        int right=solve(obstacleGrid,x,y+1,grid);
        return grid[x][y]=left+right;


    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int grid[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            Arrays.fill(grid[i],-1);
        }
        return solve(obstacleGrid,0,0,grid);
        

    }
}