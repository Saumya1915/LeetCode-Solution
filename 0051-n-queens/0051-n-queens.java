class Solution {
    public boolean isSafe(int index,int[][] matrix,int n){
        
        int x=n;
        int y=index;

        while(x>=0){
            if(matrix[x][y]==1){
                return false;
            }
            x--;
        }

        x=n;
        y=index;

        while(x>=0 &&  y>=0){
            if(matrix[x][y]==1){
                return false;
            }
            x--;
            y--;
        }

        x=n;
        y=index;

        while(x>=0 &&  y<matrix.length){
            if(matrix[x][y]==1){
                return false;
            }
            x--;
            y++;
        }

        return true;
    }
    public void solve(int[][] matrix,int n,List<List<String>>ans,int i){
       if(i==n)
       {
        
        List<String> list=new ArrayList<>();
        for(int j=0;j<n;j++){
            StringBuilder str=new StringBuilder();
            for(int k=0;k<n;k++)
            {
                if(matrix[j][k]==1){
                    str.append("Q");
                }
                else{
                    str.append(".");
                }
            }
            list.add(str.toString());
        }
        ans.add(list);
        return;
       }

       for(int index=0;index<n;index++){
            if(isSafe(index,matrix,i))
            {
                matrix[i][index]=1;
                solve(matrix,n,ans,i+1);
                matrix[i][index]=0;
            }

       }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        int matrix[][]=new int[n][n];
        solve(matrix,n,ans,0);
        return ans;

    }
} 