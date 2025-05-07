class Solution {

    public int solve(int[][] grid,int x1,int y1,int x2,int y2,int[][][][] dp){

        if(x1>=grid.length || x2>=grid.length|| y1>=grid[0].length || y2>=grid[0].length|| 
        grid[x1][y1]==-1 || grid[x2][y2]==-1){
            return Integer.MIN_VALUE;
        }

        if(x1==grid.length-1 && y1==grid[0].length-1){
            return grid[x1][y1];
        }

        if(x2==grid.length-1 && y2==grid[0].length-1){
            return grid[x2][y2];
        }

        if(dp[x1][y1][x2][y2]!=-1){
            return dp[x1][y1][x2][y2];
        }

        int cherry=0;
        if(x1==x2 && y1==y2){
            cherry=grid[x1][y1];
        }
        else{
            cherry=grid[x1][y1]+grid[x2][y2];
        }

        cherry+=Math.max(Math.max(solve(grid,x1+1,y1,x2,y2+1,dp),solve(grid,x1+1,y1,x2+1,y2,dp)),Math.max(solve(grid,x1,y1+1,x2+1,y2,dp),solve(grid,x1,y1+1,x2,y2+1,dp)));
        return dp[x1][y1][x2][y2]=cherry;


    }
    public int cherryPickup(int[][] grid) {
        int dp[][][][]=new int[grid.length][grid[0].length][grid.length][grid[0].length];
        for(int[][][] row:dp){
            for(int[][] row2:row){
                for(int[] row3:row2){
                    Arrays.fill(row3,-1);
                }
            }
        }
        return Math.max(0,solve(grid,0,0,0,0,dp));




        
    }
}