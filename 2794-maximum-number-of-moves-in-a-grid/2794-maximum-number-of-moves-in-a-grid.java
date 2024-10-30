class Solution {

    public int maxMoves(int[][] grid) 
    {
        int col=grid[0].length;
        int row=grid.length;

        int[][] dp=new int[row][col];

         
        for(int i=0;i<row;i++)
        {
            dp[i][col-1]=0;
        }

        for(int j=col-2;j>=0;j--)
        {

            for(int i=0;i<row;i++)
            {
               
                int x=i;
                int y=j;

                int[][] dir={{0,1},{-1,1},{1,1}};

                for(int di[]:dir)
                {

                    int newx=x+di[0];
                    int newy=y+di[1];

                    if(newx>=0 && newx<grid.length && newy>=0 && newy<col && grid[newx][newy]>grid[x][y])
                    {

                        dp[x][y]= Math.max(dp[newx][newy]+1,dp[x][y]);

                    }
                }
            }
        }
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<row;i++)
        {
            maxi=Math.max(dp[i][0],maxi); 
        }
        return maxi;
    }
    
}