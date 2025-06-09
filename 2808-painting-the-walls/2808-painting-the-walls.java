class Solution {
    int solve(int remain,int index,int cost[],int time[],int dp[][]){

        if(remain<=0){
            return 0;
        }
        if(index==0){
            if(remain-1-time[index]<=0){
                return cost[index];
            }
            else{
                return Integer.MAX_VALUE;
            }
        }
        if(dp[index][remain]!=-1){
            return dp[index][remain];
        }
        int not=solve(remain,index-1,cost,time,dp);
        int take=Integer.MAX_VALUE;
        int num=solve(remain-1-time[index],index-1,cost,time,dp);
        if(num!=Integer.MAX_VALUE){
                take=cost[index]+num;
        }
        
        return dp[index][remain]=Math.min(not,take);

        
    }
    public int paintWalls(int[] cost, int[] time) {
        int dp[][]=new int[cost.length][cost.length+1];
        for(int row[]:dp){
            Arrays.fill(row,Integer.MAX_VALUE/2);
        }
        //return solve(cost.length,cost.length-1,cost,time,dp);
        for(int i=1;i<=cost.length;i++){
             if(i<=1+time[0]){
                dp[0][i]=cost[0];
             }
        }
        for(int i=0;i<cost.length;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<cost.length;i++)
        {

            for(int j=1;j<=cost.length;j++){

                int not=dp[i-1][j];

                //if(j-1-time[i]>=0)
                int take=cost[i]+dp[i-1][Math.max(0,j-1-time[i])];
                
        
                dp[i][j]=Math.min(not,take);
            }
        }
        return dp[cost.length-1][cost.length];
        
    }
}