class Solution {
    public int countSquares(int[][] matrix) {
        int ans[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==1){
                ans[0][i]=1;
            }
        }

        for(int i=0;i<matrix.length;i++)
        {
            if(matrix[i][0]==1){
                ans[i][0]=1;
            }
        }

        for(int i=1;i<matrix.length;i++){

            for(int j=1;j<matrix[0].length;j++){

                if(matrix[i][j]==1){
                    ans[i][j]=Math.min(ans[i-1][j],Math.min(ans[i][j-1],ans[i-1][j-1]))+1;
                }
            }
        }

        int sum=0;

        for(int i=0;i<matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){
                System.out.print(ans[i][j]+" ");
                sum+=ans[i][j];
            }
            System.out.println();
        }
        return sum;
    }
}