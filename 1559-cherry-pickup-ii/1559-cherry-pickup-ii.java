class Solution {
    int solve(int[][] grid,int i,int j1,int j2,int[][][] dp){

        if(i>=grid.length || j1>=grid[0].length || j2>=grid[0].length || j1<0 || j2<0){
            return Integer.MIN_VALUE;
        }
        if(i==grid.length-1){

            if(j1==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }

        int maxi=0;
        for(int t=-1;t<=1;t++){

            for(int j=-1;j<=1;j++)
            {

                if(j1==j2){
                    maxi=Math.max(maxi,grid[i][j1]+solve(grid,i+1,j1+t,j2+j,dp));
                }
                else{

                    int sum=grid[i][j1]+grid[i][j2];
                    maxi=Math.max(maxi,sum+solve(grid,i+1,j1+t,j2+j,dp));
                }
            }
        }
        return dp[i][j1][j2]=maxi;

    }
    public int cherryPickup(int[][] grid) {
        int dp[][][]=new int[grid.length][grid[0].length][grid[0].length];
        for(int[][] row:dp){
            for(int[] rows:row){
                Arrays.fill(rows,-1);
            }
        }

        return solve(grid,0,0,grid[0].length-1,dp);
        

    }
}