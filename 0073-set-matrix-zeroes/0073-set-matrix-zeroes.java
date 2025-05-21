class Solution {
    public void setZeroes(int[][] matrix) {
     int col=matrix[0].length;
     int row=matrix.length;
     boolean col1=false;
     for(int i=0;i<row;i++)
     {
         if(matrix[i][0]==0){
             col1=true;
         }
         for(int j=1;j<col;j++){
             if(matrix[i][j]==0){
                 matrix[0][j]=0;
                 matrix[i][0]=0;
             }
         }
     }
     for(int i=row-1;i>=0;i--)  {
         for(int j=col-1;j>=1;j--){
           if(matrix[0][j]==0 || matrix[i][0]==0)
           {
               matrix[i][j]=0;
           }
         }
         if(col1){
             matrix[i][0]=0;
         }
     }
     /** if(col1){
           for(int i=0;i<row;i++){
               matrix[i][0]=0;
           }
     }*/

    }
}