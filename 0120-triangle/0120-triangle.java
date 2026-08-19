class Solution {
    public int solve(List<List<Integer>> list, int x,int y,
    int[][] grid){
        if(x==list.size()-1){
            return list.get(x).get(y);
        }

        if(grid[x][y]!=-1){
            return grid[x][y];
        }

        int up=solve(list,x+1,y,grid);
        int left=solve(list,x+1,y+1,grid);
        return grid[x][y]=list.get(x).get(y)+Math.min(up,left);

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int grid[][]=new int[triangle.size()][triangle.size()];
        // for(int i=0;i<triangle.size();i++){
        //      Arrays.fill(grid[i],Integer.MAX_VALUE);
        //  }
        // return solve(triangle, 0,0,grid);

        grid[0][0]=triangle.get(0).get(0);

        for(int i=1;i<triangle.size();i++)
        {

            for(int j=0;j<=i;j++)
            {
                int up=Integer.MAX_VALUE;
                int left=Integer.MAX_VALUE;
                if(j-1>=0)
                {
                    left=grid[i-1][j-1];
                }
                if(j<i){
                    up=grid[i-1][j];
                }
                grid[i][j]=triangle.get(i).get(j)+Math.min(up,left);

            }
        }

        int mini=Integer.MAX_VALUE;

        for(int i=0;i<triangle.size();i++){
            mini=Math.min(mini,grid[triangle.size()-1][i]);
        }
        return mini;


    }
}