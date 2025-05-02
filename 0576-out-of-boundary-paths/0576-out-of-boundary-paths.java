class Solution {
    int solve(int x,int y,int moves,int maxMove,int m,int n,int dp[][][]){
        if(moves>maxMove){
            return 0;
        }
        if((x>=m || x<0|| y<0|| y>=n) && moves<=maxMove){
            return 1;
        }
        if(dp[x][y][moves]!=-1){
            return dp[x][y][moves];
        }
        int up=solve(x+1,y,moves+1,maxMove,m,n,dp)%1000000007;
        int down=solve(x-1,y,moves+1,maxMove,m,n,dp)%1000000007;
        int right=solve(x,y+1,moves+1,maxMove,m,n,dp)%1000000007;
        int left=solve(x,y-1,moves+1,maxMove,m,n,dp)%1000000007;
      
        return dp[x][y][moves]=(((up + down) % 1000000007 + (right + left) % 1000000007) % 1000000007);
        
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int dp[][][]=new int[m][n][maxMove+1];
        for(int row[][]:dp){
            for(int rows[]:row){
            Arrays.fill(rows,-1);}
        }
        return solve(startRow,startColumn,0,maxMove,m,n,dp);
    }
}