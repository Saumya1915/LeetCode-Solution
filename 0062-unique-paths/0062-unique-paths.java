class Solution {
    public int solve(int x,int y,int dp[][]){
        if(x==0 && y==0){
            return 1;

        }

        if(x<0 || y<0){
            return 0;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }


        int left=solve(x,y-1,dp);
        int up=solve(x-1,y,dp);
        return dp[x][y]=left+up;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,0);
        }
        //return solve(m-1,n-1,dp);
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int left=dp[i][j-1];
                int up=dp[i-1][j];
                dp[i][j]=left+up;
            }
        }
        return dp[m-1][n-1];
    }
}