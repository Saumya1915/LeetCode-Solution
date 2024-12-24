class Solution {
    public int solve(int nums[],int index,int dp[]){
        if(index<0){
            return 0;
        }
        if(index==0){
            return nums[0];
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int sum=solve(nums,index-1,dp);
        int sum2=nums[index]+solve(nums,index-2,dp);
        dp[index]= Math.max(sum,sum2);
        return Math.max(sum,sum2);
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,nums.length-1,dp);
        
    }
}