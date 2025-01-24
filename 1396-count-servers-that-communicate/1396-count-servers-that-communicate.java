class Solution {
    public int solve(int[][] grid, int i,int j,int[][] ans){

        if(i>=grid.length || j>=grid[0].length){
            return 0;
        }
        ans[i][j]=1;
        int count=0;
        for(int index=0;index<grid.length;index++){
            if(grid[index][j]==1 && ans[index][j]==0){
                count+=solve(grid,index,j,ans);
            }
        }

        for(int index=0;index<grid[0].length;index++){
            if(grid[i][index]==1 && ans[i][index]==0){
                count+=solve(grid,i,index,ans);
            }
        }

        return count+1;




        
    }
    public int countServers(int[][] grid) {
        int serversCommunicating=0;
        int ans[][]=new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){

            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]==1 &&  ans[i][j]==0){
                    int value=solve(grid,i,j,ans);
                    if(value>1){
                        serversCommunicating+=value;
                    }
                }
            }
        }

        return serversCommunicating;

    }
}