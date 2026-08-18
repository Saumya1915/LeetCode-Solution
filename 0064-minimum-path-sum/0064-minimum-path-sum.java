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
        int ans[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){

            Arrays.fill(ans[i],-1);
        }

        return solve(grid,grid.length-1,grid[0].length-1,ans);

        
    }
}