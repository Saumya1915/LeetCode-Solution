class Solution {
    public boolean solve(int nums[],int target,int index,int sum,int[][] dp){
        if(index==nums.length){
            if(target-sum==sum){
                return true;
            }
            else{
                return false;
            }
        }
        if(dp[index][sum]!=-1){
            return dp[index][sum]==1;
        }

        //not take 
        Boolean a=solve(nums,target,index+1,sum,dp);
        Boolean b=solve(nums,target,index+1,sum+nums[index],dp);
        if((a||b)==true){
            dp[index][sum]=1;
        }
        else{
            dp[index][sum]=0;
        }
        return a||b;
    

    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

        }
        int dp[][]=new int[nums.length][sum];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,sum,0,0,dp);
    }
}