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
            Arrays.fill(row,-1);
        }
        return solve(cost.length,cost.length-1,cost,time,dp);
        
    }
}