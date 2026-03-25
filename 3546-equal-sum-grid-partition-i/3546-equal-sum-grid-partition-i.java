class Solution {
    public boolean canPartitionGrid(int[][] grid) 
    {
        long sum=0;
        for(int i=0;i<grid.length;i++)
        {

            for(int j=0;j<grid[0].length;j++){

                sum+=grid[i][j];
            }

        }
         if(sum==0){
            return false;
         }
        
        long elements=0;
         for(int i=0;i<grid.length-1;i++){

            for(int j=0;j<grid[0].length;j++)
            {
                elements+=grid[i][j];
                
            }
            long diff=sum-elements;
            if(diff==elements)
            {
                return true;
            }

         }
         
         elements=0;
         for(int i=0;i<grid[0].length-1;i++){

            for(int j=0;j<grid.length;j++)
            {
                elements+=grid[j][i];
                
            }
            long diff=sum-elements;
            if(diff==elements)
            {
                return true;
            }

         }

         return false;
    }
}