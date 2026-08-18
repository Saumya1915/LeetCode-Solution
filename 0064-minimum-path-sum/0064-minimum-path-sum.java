class Solution {
    public int solve(int[][]  grid,int x,int y,int[][] ans){

        if(x==0 && y==0){
            return grid[x][y];
        }

        if(x<0 || y<0){
            return Integer.MAX_VALUE;
        }

        if(ans[x][y]!=-1){
            return ans[x][y];
        }

        int left=solve(grid, x-1,y,ans);
        int right=solve(grid,x,y-1,ans);
        return ans[x][y]=grid[x][y]+Math.min(left,right);
    }
    public int minPathSum(int[][] grid) {
        //int ans[][]=new int[grid.length][grid[0].length];
        // for(int i=0;i<grid.length;i++){

        //     Arrays.fill(ans[i],-1);
        // }

        // return solve(grid,grid.length-1,grid[0].length-1,ans);

        // ans[0][0]=grid[0][0];
        // for(int i=1;i<grid[0].length;i++){
        //     ans[0][i]=ans[0][i-1]+grid[0][i];
        // }

        // for(int i=1;i<grid.length;i++){

        //     for(int j=0;j<grid[0].length;j++){

        //         if(i-1>=0 && j-1>=0){
        //             int left=ans[i-1][j];
        //             int right=ans[i][j-1];
        //             ans[i][j]=grid[i][j]+Math.min(left,right);

        //         }
        //         else{

        //             ans[i][j]=grid[i][j]+ans[i-1][j];
        //         }
        //     }
        // }
        // return ans[grid.length-1][grid[0].length-1];

        int ans[]=new int[grid[0].length];
        ans[0]=grid[0][0];

        for(int i=1;i<grid[0].length;i++){
            ans[i]=ans[i-1]+grid[0][i];
        }

        for(int i=1;i<grid.length;i++)
        {

            for(int j=0;j<grid[0].length;j++){

                if(j-1<0){
                    ans[j]=grid[i][j]+ans[j];
                }
                else{
                    ans[j]=grid[i][j]+Math.min(ans[j-1],ans[j]);
                }
            }
        }
        return ans[grid[0].length-1];



        
    }
}