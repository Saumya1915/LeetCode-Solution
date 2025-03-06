class Solution {
    public int solve(int[] nums,int start,int end,int dp[]){

        if(end==0 && start==0){
            return nums[end];
        }
        if(end==1 && start==1){
            return nums[end];
        }
        if(start>end){
            return 0;
        }

        if(dp[end]!=-1){
            return dp[end];
        }


        int pick=nums[end]+solve(nums,start,end-2,dp);
        int notPick=solve(nums,start,end-1,dp);
        return dp[end]=Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        int option1=solve(nums,0,nums.length-2,dp);
        Arrays.fill(dp,-1);

        int option2=solve(nums,1,nums.length-1,dp);
        return Math.max(option1,option2);
        
    }
}